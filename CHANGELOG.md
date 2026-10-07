# Changelog

## [1.2.0](https://github.com/Azure/osdu-spi-file/compare/v1.1.0...v1.2.0) (2026-10-07)


### ✨ Features

* Add vendor-neutral OIDC authentication support for acceptance tests ([ef21e9e](https://github.com/Azure/osdu-spi-file/commit/ef21e9e6df900b9530746a9119cda991f9daa699))
* Add vendor-neutral OIDC authentication support for acceptance tests ([702723a](https://github.com/Azure/osdu-spi-file/commit/702723a075c743a9cb802427d8156cd0ff438592))
* Initial code ([046abcf](https://github.com/Azure/osdu-spi-file/commit/046abcfa2cee8ce4b61e228efa677e023352f995))


### 🐛 Bug Fixes

* AWS acceptance single-prefix ACL (201/200) + presigned-URL download 403 ([8c702c1](https://github.com/Azure/osdu-spi-file/commit/8c702c19efe018f4e6e8688e0e6e038cf4052f2b))
* AWS acceptance single-prefix ACL (201/200) + presigned-URL download 403 ([8684b2d](https://github.com/Azure/osdu-spi-file/commit/8684b2db69b3ab254fbac45e320d350e7af67fa3))
* Aws issue generating download urls of 15 minute durations ([c527f7d](https://github.com/Azure/osdu-spi-file/commit/c527f7d06449f681f1d03e33c0b89d96e5c8e227))
* Aws issue generating download urls of 15 minute durations ([565f80b](https://github.com/Azure/osdu-spi-file/commit/565f80b9d8d8f0a7cba6b9ea71f06602d9228290))
* **aws:** Bump c-ares pin to 1.34.8-r0 to fix file-aws image build ([b473d43](https://github.com/Azure/osdu-spi-file/commit/b473d43ce6df5cc1d01b1529d250b26549b68824))
* **aws:** Bump c-ares pin to 1.34.8-r0 to fix file-aws image build ([ab6232d](https://github.com/Azure/osdu-spi-file/commit/ab6232d97782d7bf7cde920aceaf31f5dbd313c2))
* **azure:** Netty-bom before core-lib-azure (lettuce 7.5.2 NoClassDefFoundError) ([74631f0](https://github.com/Azure/osdu-spi-file/commit/74631f00229ceac3ae0d9a4da2565e1f6cd15e0a))
* **azure:** Netty-bom before core-lib-azure (lettuce 7.5.2 NoClassDefFoundError) ([928a7be](https://github.com/Azure/osdu-spi-file/commit/928a7becbb82675b5ffc97142be14331c80b5194))
* Cve and spring boot version bump ([b2a09e0](https://github.com/Azure/osdu-spi-file/commit/b2a09e0ce93dbfa42fb538dbb3476919cd6fc992))
* Cve and spring boot version bump ([30e713c](https://github.com/Azure/osdu-spi-file/commit/30e713c10a9311e722383a0f9d84cd0ddf9fd994))
* Cve fix for jackson-dataformat ([d91c72d](https://github.com/Azure/osdu-spi-file/commit/d91c72db39caefb0d3fd24422e7c11ed69c6b550))
* Cve fix for jackson-dataformat ([f50e02d](https://github.com/Azure/osdu-spi-file/commit/f50e02da02211c18c1edb336268a186116e7d13d))
* **cve:** Remediate HIGH/CRITICAL deps + pom cleanup ([ed11f43](https://github.com/Azure/osdu-spi-file/commit/ed11f433b7c793df64d0138eda6a3aa130b1ff31))
* **cve:** Remediate HIGH/CRITICAL deps + pom cleanup ([4fdafc2](https://github.com/Azure/osdu-spi-file/commit/4fdafc21f00a0ed114dfebdb5d097135151bdf91))
* **docs:** Correct S3 config markdown anchor in baremetal README ([5366ea6](https://github.com/Azure/osdu-spi-file/commit/5366ea6bc1149aa72b51b480c50da7eb857c9e5b))
* Error handling for invalid file path converts 400 to 500 by global exception handler ([dd30689](https://github.com/Azure/osdu-spi-file/commit/dd3068941324572cf6fc8f25d2647e8ea8f44a14))
* Error handling for invlaid file path converts 400 to 500 by global exception handler ([8dc7dc2](https://github.com/Azure/osdu-spi-file/commit/8dc7dc216f8a50b2b1d0be2336b3e6305d6ec597))
* **file-azure:** Bump core-lib-azure to 3.0.3 for single-scope workload identity tokens ([36740b7](https://github.com/Azure/osdu-spi-file/commit/36740b7915a6a77838a52ec9347c9f293b06dd4f))
* Gc chart: add default SA name ([fe88346](https://github.com/Azure/osdu-spi-file/commit/fe88346aa6009d262ad0f56190d0ac4827cb5df8))
* Gc chart: add default SA name ([929440c](https://github.com/Azure/osdu-spi-file/commit/929440cf5b4ec96d51a59df35bc03e368379ea06))
* SIGNED_URL_EXPIRY_TIME_MINUTES Override, Local Acceptance Test Build and README ([9b28f55](https://github.com/Azure/osdu-spi-file/commit/9b28f553099fe637d743ea57adb01cc97d788108))
* SIGNED_URL_EXPIRY_TIME_MINUTES Override, Local Acceptance Test Build and README ([4c25c0e](https://github.com/Azure/osdu-spi-file/commit/4c25c0e668e16e0e74b26f3744f582c8442de23e))
* Spring boot netty handler c-ares version bump ([e5b63da](https://github.com/Azure/osdu-spi-file/commit/e5b63da37549112e61c076fb27dc868fd97c4fe1))
* Spring boot netty handler c-ares version bump ([dfa1f54](https://github.com/Azure/osdu-spi-file/commit/dfa1f547431ac915fa38667784b02846e337fc7d))
* Spring security update ([2638f87](https://github.com/Azure/osdu-spi-file/commit/2638f8789d0765eaadc8be7ac7d458bb3c27e567))
* Spring security update ([258a4d8](https://github.com/Azure/osdu-spi-file/commit/258a4d84bde8a831ab620d32fdf4043bcdc40d2c))
* Spring-core tomcat netty version bump ([ed6be42](https://github.com/Azure/osdu-spi-file/commit/ed6be428bbd7d3481bb472037a0c40b130d89011))
* Spring-core tomcat netty version bump ([9d852dc](https://github.com/Azure/osdu-spi-file/commit/9d852dc404f4dc276d82cf2c0cd1562a877bbad0))
* Sync upstream changes from e7ef32a0 ([da12fd9](https://github.com/Azure/osdu-spi-file/commit/da12fd9c3fa929f1719c97ff7226b8a6fa336658))
* **test:** Skip tearDown cleanup when containerName is blank ([2fbaace](https://github.com/Azure/osdu-spi-file/commit/2fbaace8f2735a116def203e76e3144868268022))
* Throws 400 error when getFileList request filter returns no results ([3aedbc8](https://github.com/Azure/osdu-spi-file/commit/3aedbc8f9c44c6df15cbb3f74c40ded2ebd17b31))
* Throws 400 error when getFileList request filter returns no results ([664dac7](https://github.com/Azure/osdu-spi-file/commit/664dac7a1f68eae66ffe0494e3251b3f2b00b9ff))
* Tomcat cve ([fc81fcb](https://github.com/Azure/osdu-spi-file/commit/fc81fcb0b0c0335f3cd5db5230020fdec10e6c6d))
* Validation of max key length using S3 on AWS ([70eedd7](https://github.com/Azure/osdu-spi-file/commit/70eedd73db7bb1e39a0c504f1b4ffdfde7704ce7))
* Validation of max key length using S3 on AWS ([409ea11](https://github.com/Azure/osdu-spi-file/commit/409ea1195307417720a2feebfb6564866cab1261))


### 📚 Documentation

* Add Apache 2.0 license headers to azure sources ([95a6ad7](https://github.com/Azure/osdu-spi-file/commit/95a6ad7c1a62995bc851084490637525e60ee2ae))
* **azure:** Mark provider README as Microsoft-maintained and point deployment at SPI Stack ([c606845](https://github.com/Azure/osdu-spi-file/commit/c60684580b11c3ee73682a9d2d73f63bb2ff487d))
* **azure:** Rewrite provider README in the standard SPI service format ([a615cb3](https://github.com/Azure/osdu-spi-file/commit/a615cb3fcbb6498213f3f4bec31702e2a2c51771))
* Clarify OSDU_ENTITLEMENTS_APP_KEY usage ([c270612](https://github.com/Azure/osdu-spi-file/commit/c270612f40c87ec4d61e9c18fe46fd1f7f095ad2))
* Clarify when deploy and test proves a change ([7694ada](https://github.com/Azure/osdu-spi-file/commit/7694ada7b17513a9c66b5fb8cc8667cb21b1e25a))
* Correct required Maven version in README ([6504bcc](https://github.com/Azure/osdu-spi-file/commit/6504bccb4cc7c61b3af1c7306dd37c418d03b7f7))
* **file-azure:** Add release, validate, and license badges ([e8929dc](https://github.com/Azure/osdu-spi-file/commit/e8929dc1eabc2dac2de58fc34f2c7efaf9a5afdf))
* **file-azure:** Clarify when CI builds and deploys ([73d8248](https://github.com/Azure/osdu-spi-file/commit/73d8248650850994854089442adaa4b5bf86ac2c))
* **file-azure:** Document repo ownership and SPI Stack setup ([9e4cd61](https://github.com/Azure/osdu-spi-file/commit/9e4cd6127c5200dadcd93f6f032350fe67c61d63))
* **file-azure:** Rewrite provider README around SPI Stack ([770fcb9](https://github.com/Azure/osdu-spi-file/commit/770fcb9df6425a69486489958866f70aa5326890))
* Keep the configuration table inside the README width ([eeec703](https://github.com/Azure/osdu-spi-file/commit/eeec703be7aeaf13d8c28904f856974d6ebc391e))
* Make the root README fork-owned and move the Azure documentation there ([a500229](https://github.com/Azure/osdu-spi-file/commit/a50022989785f75e27785b202cccadee2df0f151))
* Merge variable and value columns in file env table ([ce7ca88](https://github.com/Azure/osdu-spi-file/commit/ce7ca8829eb41d9a187eddf9e5c5a6ce03c92b99))
* Move Azure provider README to repository root ([53e908b](https://github.com/Azure/osdu-spi-file/commit/53e908bc0bdbc5aee00301b0b968c974f683fe05))


### 🔧 Miscellaneous

* Add service descriptor ([08cc3f3](https://github.com/Azure/osdu-spi-file/commit/08cc3f392eb0b578f745efe9d3e58c5c57db7097))
* **ci:** Remove IBM jobs from pipeline ([5f24fd1](https://github.com/Azure/osdu-spi-file/commit/5f24fd1ce327e233abe98a238aeede39683815d2))
* **ci:** Remove IBM jobs from pipeline ([ae8856c](https://github.com/Azure/osdu-spi-file/commit/ae8856cb088cccb8444af374a7aaca4b74ab29b7))
* Complete repository initialization ([7c7d992](https://github.com/Azure/osdu-spi-file/commit/7c7d99228671d3d4a00a548395984129ff99db7b))
* Copy configuration and workflows from main branch ([7246e4f](https://github.com/Azure/osdu-spi-file/commit/7246e4f5b8cff29f34fc229784bcaeb9682b2a23))
* Deleting aws helm chart ([4ad1dc9](https://github.com/Azure/osdu-spi-file/commit/4ad1dc94ca9bb59f6d49b21a29d7fba0ca64111b))
* Deleting aws helm chart ([47c1a0a](https://github.com/Azure/osdu-spi-file/commit/47c1a0a7be5375ba9244d0d7a75aa95546413b03))
* **deps:** Security remediation - Spring Boot 3.5.8, Spring Cloud 2025.0.0 ([dda0707](https://github.com/Azure/osdu-spi-file/commit/dda07070269e5ff83107de2fed98c9dd629c5f69))
* **deps:** Security remediation - Spring Boot 3.5.8, Spring Cloud 2025.0.0 ([6fa1324](https://github.com/Azure/osdu-spi-file/commit/6fa13247db10941d50d3121d29efb35fdb6c74a0))
* **deps:** Update commons-fileupload to 1.6.0 ([fd60cbf](https://github.com/Azure/osdu-spi-file/commit/fd60cbf52fe2624c1eaa515c58cb39f2b58e5d22))
* **deps:** Update commons-fileupload to 1.6.0 ([e93dc49](https://github.com/Azure/osdu-spi-file/commit/e93dc494e4c733839f55933471112b78cb3ec6d8))
* **gc:** Decouple Google Cloud provider code (GONRG-15319) ([e7ef32a](https://github.com/Azure/osdu-spi-file/commit/e7ef32a00f6ecc566b5a6d13b147159b6f55b435))
* **gc:** Decouple Google Cloud provider code (GONRG-15319) ([a5d9ee9](https://github.com/Azure/osdu-spi-file/commit/a5d9ee976a79b0f0f6207fd196435c47056c0a32))
* Generate filtered upstream tree ([0534cce](https://github.com/Azure/osdu-spi-file/commit/0534ccea40dff1754aec42e8156008d473ae509b))
* Generate filtered upstream tree ([fe21291](https://github.com/Azure/osdu-spi-file/commit/fe2129180fe66d21e5402d662785ec10059d4ad2))
* **github:** Add upstream filter config for file service ([6d55ce7](https://github.com/Azure/osdu-spi-file/commit/6d55ce7981ab7665b4e8fe04faea4a849e251392))
* License headers for the release review ([491f665](https://github.com/Azure/osdu-spi-file/commit/491f66536daf6a060a0b143f9c64bd849fe094e7))
* Remove AWS provider and AWS CI/CD ([af461e8](https://github.com/Azure/osdu-spi-file/commit/af461e8c8aa55245f289118f13029757ed6ac8ee))
* Remove AWS provider and AWS CI/CD ([0602220](https://github.com/Azure/osdu-spi-file/commit/060222019ef54ac0841ee787fbe78e0c51588a50))
* Removing helm copy from aws buildspec ([688d1bd](https://github.com/Azure/osdu-spi-file/commit/688d1bd2027072fcc0a87f109ade672c12733647))
* Seed fork-owned azure trees ([556aba0](https://github.com/Azure/osdu-spi-file/commit/556aba0037f6fd15e9fe2c1b451513b5a6a8167c))
* **spi:** Add spi service descriptor for file service ([c82443c](https://github.com/Azure/osdu-spi-file/commit/c82443cbf8237ba397a2a95c69985a873da5e185))
* Sync template updates ([1fba375](https://github.com/Azure/osdu-spi-file/commit/1fba375791a6b110aa27b2e87c6be2d2caca95de))
* Sync template updates ([c5190f7](https://github.com/Azure/osdu-spi-file/commit/c5190f7b20c425421d8600d6f17e5ec42189026b))
* **template-sync:** Sync template updates (updated 2026-10-05) ([0af4745](https://github.com/Azure/osdu-spi-file/commit/0af474519d2740cedce0c2d431be544d762589dd))
* **template-sync:** Sync template updates 2026-10-06 ([56b191e](https://github.com/Azure/osdu-spi-file/commit/56b191e3433240b1a1e34ebb0b01cf94b1c59dbb))


### ♻️ Code Refactoring

* **audit:** Encapsulate audit roles in logging layer ([2b149c5](https://github.com/Azure/osdu-spi-file/commit/2b149c5ec48451034fbc2562c7cbe622f41843d1))
* **audit:** Encapsulate audit roles in logging layer ([4efe561](https://github.com/Azure/osdu-spi-file/commit/4efe5611720a0b6f5e75c8b60587448890d6d3c4))
* **logging:** Align file metadata and OSM logging with JaxRsDpsLog ([84db264](https://github.com/Azure/osdu-spi-file/commit/84db26464f0c7ef629b3b4785a802fb88241e4c1))


### 🧪 Tests

* Validate File Collection S3 signing credentials ([53ef4b0](https://github.com/Azure/osdu-spi-file/commit/53ef4b0a94c287df6d4fe022b0daa66e0f2056e1))
* Validate File Collection S3 signing credentials ([843d6d8](https://github.com/Azure/osdu-spi-file/commit/843d6d89c69c751fd2afbb04df06a043a6b1c1f8))


### 🔨 Build System

* **deps-dev:** Bump com.azure:azure-storage-blob ([a250e81](https://github.com/Azure/osdu-spi-file/commit/a250e8175b6e7cb76bb4c17c528d8a6b4de4502a))
* **deps-dev:** Bump com.azure:azure-storage-blob from 12.25.2 to 12.25.4 in /testing/file-test-azure ([097dea3](https://github.com/Azure/osdu-spi-file/commit/097dea327ed055590689c985e5be41ead1d4963c))
* **deps:** Bump azure-core-http-netty to 1.15.1 in test ([be2b34e](https://github.com/Azure/osdu-spi-file/commit/be2b34ed9654425c69fb64ccf3c9768bd1303173))
* **deps:** Bump azure-identity, azure-core, and guava in test ([007b4ea](https://github.com/Azure/osdu-spi-file/commit/007b4ea42be7e5e589111c4b2b806fa1f47beafa))
* **deps:** Bump azure-identity, azure-core, and guava in test ([0015c66](https://github.com/Azure/osdu-spi-file/commit/0015c665edcd5c422bce72fafe912e70302383df))
* **deps:** Bump core-lib-azure to 3.0.3 in file-azure ([a611981](https://github.com/Azure/osdu-spi-file/commit/a6119815c0ad1fd696bffba9201d93acfa4bcd31))
* Remove redundant version declarations from child modules ([631a10a](https://github.com/Azure/osdu-spi-file/commit/631a10a44e1d854a36fb81900da9d0b3a5423e73))
* Remove redundant version declarations from child modules ([86651bf](https://github.com/Azure/osdu-spi-file/commit/86651bf6d9a2f31d6cd11863bef9d1ec55c8f0f4))
