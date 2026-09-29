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

package org.opengroup.osdu.file.azure.Helper;

import com.azure.storage.file.datalake.DataLakeDirectoryClient;
import com.azure.storage.file.datalake.DataLakeFileClient;
import com.azure.storage.file.datalake.DataLakePathClientBuilder;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class DataLakeHelper {

  public void uploadFile(String signedUrl, String content, String fileName) throws IOException {
    DataLakeDirectoryClient directoryClient = new DataLakePathClientBuilder()
        .endpoint(signedUrl)
        .buildDirectoryClient();
    DataLakeFileClient fileClient = directoryClient.createFile(fileName);
    InputStream targetStream = new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8));

    long fileSize = content.length();
    fileClient.append(targetStream, 0, fileSize);
    fileClient.flush(fileSize, true);
    targetStream.close();
  }

  public ByteArrayOutputStream downloadFile(String signedUrl, String fileName) {

    DataLakeDirectoryClient directoryClient = new DataLakePathClientBuilder()
        .endpoint(signedUrl)
        .buildDirectoryClient();
    DataLakeFileClient fileClient = directoryClient.getFileClient(fileName);
    ByteArrayOutputStream targetStream = new ByteArrayOutputStream();

    fileClient.read(targetStream);
    return targetStream;
  }
}
