package org.opengroup.osdu.file.api;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith({SpringExtension.class, MockitoExtension.class})
@MockitoSettings(strictness = Strictness.LENIENT)
public class HealthCheckApiTest {

  @InjectMocks
  private HealthCheckApi healthCheckApi;

  @Test
  public void test_livenessCheck() {
    ResponseEntity<String> response = healthCheckApi.livenessCheck();
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals("File service is alive", response.getBody());
  }

  @Test
  public void test_readinessCheck() {
    ResponseEntity<String> response = healthCheckApi.readinessCheck();
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals("File service is ready", response.getBody());
  }
}
