# OSDU File Service for Azure

[![Release](https://img.shields.io/github/v/release/Azure/osdu-spi-file)](https://github.com/Azure/osdu-spi-file/releases)
[![Validate](https://github.com/Azure/osdu-spi-file/actions/workflows/validate.yml/badge.svg?branch=main)](https://github.com/Azure/osdu-spi-file/actions/workflows/validate.yml)
[![License: Apache 2.0](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](LICENSE)

> [!NOTE]
> Shared service code comes from the [OSDU community upstream](https://community.opengroup.org/osdu/platform/system/file); the [OSDU documentation](https://osdu.pages.opengroup.org/platform/system/file/) covers the API.

File hands out time-bound signed URLs for uploading and downloading files, and stores the metadata record that describes each file once it lands.

## At a glance

| | |
|---|---|
| API base path | `/api/file/v2/` |
| Swagger UI | `/api/file/v2/swagger` |
| Health | `:8081/actuator/health` |
| Depends on | Partition, Entitlements, Storage, Search |
| Azure resources | Storage and Data Lake (staging and persistent areas), Cosmos DB (file locations), Service Bus (`statuschangedtopic`) |
| Deployed by | [OSDU SPI Stack](https://github.com/Azure/osdu-spi-stack) (`software/stacks/osdu/services/file.yaml`) |

## Repository layout

[CONTRIBUTING.md](CONTRIBUTING.md) explains where each kind of change belongs.

| Path | Owner | Contents |
|---|---|---|
| `file-core/` | OSDU upstream | Shared service code |
| `provider/file-azure/` | This repository | Azure provider |
| `file-acceptance-test/` | OSDU upstream | End-to-end suite run against a deployed environment |
| `testing/file-test-azure/` | This repository | Azure integration tests |
| `.spi/service.yaml` | This repository | How CI deploys and tests the service on SPI Stack |

## Build

Requires Java 17 and Maven 3.6.3+. OSDU dependencies resolve from the public community registry through the settings file in `.mvn`:

```bash
mvn --settings .mvn/community-maven.settings.xml -P core,azure clean install
```

The runnable jar lands at `provider/file-azure/target/file-azure-*-spring-boot.jar`.

## Configuration

SPI Stack sets the service's environment from two places: the shared `osdu-config` ConfigMap and the service's own entry in [`services/file.yaml`](https://github.com/Azure/osdu-spi-stack/blob/main/software/stacks/osdu/services/file.yaml). Those files are the contract; the tables below list what File actually reads from them.

**Shared, from `osdu-config`:**

| Variable | Purpose |
|---|---|
| `KEYVAULT_URL` | Central Key Vault |
| `SERVER_PORT` | HTTP port (`8080`) |
| `AAD_CLIENT_ID` | Application ID that caller tokens are issued for, passed on as `AZURE_AD_APP_RESOURCE_ID` below |

**Specific to File**, from `services/file.yaml`:

| Variable and value on SPI Stack | Purpose |
|---|---|
| `SERVER_SERVLET_CONTEXTPATH`<br>`/api/file/` | API base path |
| `AZURE_AD_APP_RESOURCE_ID`<br>`$(AAD_CLIENT_ID)` | Token audience |
| `PARTITION_SERVICE_ENDPOINT`<br>`http://partition/api/partition/v1` | Per-partition resource lookup |
| `OSDU_ENTITLEMENTS_URL`<br>`http://entitlements/api/entitlements/v2` | Caller authorization |
| `OSDU_ENTITLEMENTS_APP_KEY`<br>`OBSOLETE` | Legacy key passed to the Entitlements client; the property has no default, so the placeholder must stay set |
| `OSDU_STORAGE_URL`<br>`http://storage/api/storage/v2` | Metadata records |
| `SEARCH_HOST`<br>`http://search/api/search/v2` | File list queries |
| `SEARCH_QUERY_LIMIT`<br>`1000` | Page size for search queries |
| `BATCH_SIZE`<br>`100` | Batch size for search queries |
| `COSMOSDB_DATABASE`<br>`osdu-db` | Database inside each partition's Cosmos DB account |
| `AZURE_PUBSUB_PUBLISH`<br>`true` | Publish file status events |
| `SERVICE_BUS_ENABLED_STATUS`<br>`true` | Publish status events to Service Bus |
| `SERVICE_BUS_TOPIC_STATUS`<br>`statuschangedtopic` | Status event topic |
| `AZURE_ISTIOAUTH_ENABLED`<br>`true` | Trust the mesh's token validation |
| `AZURE_PAAS_WORKLOADIDENTITY_ISENABLED`<br>`true` | Authenticate to Azure with workload identity |

The service authenticates to Azure with workload identity, which injects `AZURE_CLIENT_ID` and a federated token; there are no client secrets. Signed URLs are user delegation SAS, signed with a key from that identity rather than an account key. Per-partition resources are resolved at request time through the Partition service.

## Test

| Suite | Where | Runs in CI | Run it yourself |
|---|---|---|---|
| Unit | `file-core`, `provider/file-azure` | Pull requests (Java Build) | `mvn ... install` from [Build](#build) |
| Acceptance | [`file-acceptance-test`](file-acceptance-test/README.md) | Pull requests, against SPI Stack (Deploy and Test) | `spi test file` |
| Integration | `testing/file-test-azure` | Pull requests, against SPI Stack (Deploy and Test) | `spi test file --suite integration` |

CI runs these on pull requests from this repository that change code. Documentation-only changes skip the build, and pull requests from forks build without deploying.

**Acceptance** calls the deployed service through the gateway as a privileged test identity. The bindings in `.spi/service.yaml` supply its host, partition, entitlements domain, legal tag, and token.

**Integration** is the Azure suite. It sits outside the root Maven build, so the descriptor runs it from `testing/` with bearer tokens for the privileged and no-access identities. The descriptor excludes `TestFileCollection`; the end-to-end `TestFile#testFileDmsApis` flow, which needs a resource group and storage account name the stack does not bind; and the two anonymous-caller checks in `TestFile` whose names end in `Anonimus`.

Against an environment you are connected to:

```bash
spi test file --suite all            # both suites, as the environment shipped them
spi test file --suite all --source . # this checkout's suites and descriptor
```

To call the API by hand, `spi token` mints a bearer token:

```bash
curl -H "Authorization: Bearer $(spi token)" -H "data-partition-id: <partition>" \
  https://<gateway>/api/file/v2/files/uploadURL
```

## Deploy

For a pull request from this repository that changes code, CI publishes the service image and its test suite image, `osdu-spi-file-acceptance`, to GHCR, and the Deploy and Test lane borrows an SPI Stack environment, runs the new image there, proves it with the test suites, and restores the environment's own image. When that lane runs and passes, the change is proven on real infrastructure before it merges; the Validation Summary on the pull request shows whether it ran. This repository does not own infrastructure; SPI Stack does.

To try a build by hand on an environment you are connected to, pin it by digest and release the pin when done:

```bash
spi service pin file --image ghcr.io/azure/osdu-spi-file@sha256:<digest>
spi service reset file
```

## Service notes

**Revoking signed URLs.** `POST /api/file/v2/files/revokeURL` is Azure-only. It revokes every user delegation key on a storage account, which invalidates all signed URLs issued from it; URLs signed with an account key are unaffected. It needs the `service.file.admin` role and a body naming the account:

```json
{ "resourceGroup": "<resource-group>", "storageAccount": "<storage-account>" }
```

The call goes through Azure Resource Manager, so the service identity needs permission to revoke delegation keys on that account, and the process needs `AZURE_SUBSCRIPTION_ID` to pick the subscription. SPI Stack does not set `AZURE_SUBSCRIPTION_ID`, and CI does not exercise this endpoint, so treat it as unsupported on SPI Stack until both are in place. A successful call returns `204 No Content`.

## License

Copyright © Microsoft Corporation

Licensed under the [Apache License 2.0](LICENSE).
