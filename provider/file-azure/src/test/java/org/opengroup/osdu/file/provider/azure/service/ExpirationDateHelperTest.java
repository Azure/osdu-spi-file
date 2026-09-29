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

package org.opengroup.osdu.file.provider.azure.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ExpirationDateHelperTest {

  int numberOfDays = 5;

  @Test
  public void testGetExpirationDate(){
    ExpirationDateHelper expirationDateHelper = new ExpirationDateHelper();
    Date actualDate = expirationDateHelper.getExpirationDate(numberOfDays);
    Date expectedDate = new Date();
    long expTimeMillis = expectedDate.getTime();
    expTimeMillis += 1000 * 60 * 60 * 24 * numberOfDays;
    expectedDate.setTime(expTimeMillis);

    // To ignore the few ms difference - test case runs
    assertEquals(expectedDate.getTime()/10,actualDate.getTime()/10);
  }

}
