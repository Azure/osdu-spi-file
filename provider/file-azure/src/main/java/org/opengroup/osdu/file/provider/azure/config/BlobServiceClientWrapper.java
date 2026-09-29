/*
 *  Copyright © Microsoft Corporation
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.opengroup.osdu.file.provider.azure.config;

import java.util.logging.Logger;

import jakarta.inject.Inject;

import org.opengroup.osdu.azure.blobstorage.IBlobServiceClientFactory;
import org.opengroup.osdu.common.Validators;
import org.opengroup.osdu.core.common.model.http.DpsHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.azure.storage.blob.BlobServiceClient;

@Component
@RequestScope
public class BlobServiceClientWrapper {

  private final String storageAccountURL;

  @Autowired
  private final IBlobServiceClientFactory blobServiceClientFactory;

  @Inject
  public BlobServiceClientWrapper(DpsHeaders headers, IBlobServiceClientFactory blobServiceClientFactory) {
    this.blobServiceClientFactory = blobServiceClientFactory;
    String dataPartitionId = headers.getPartitionId();
    Validators.checkNotNullAndNotEmpty(dataPartitionId, "dataPartitionId");

    BlobServiceClient serviceClient = this.blobServiceClientFactory.getBlobServiceClient(dataPartitionId);
    storageAccountURL = serviceClient.getAccountUrl();
  }

  public String getStorageAccountURL() {
    return storageAccountURL.endsWith("/") ?
      storageAccountURL.substring(0, storageAccountURL.length() - 1) : storageAccountURL;
  }
}
