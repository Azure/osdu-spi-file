package org.opengroup.osdu.file.model.jackson;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.jackson2.autoconfigure.Jackson2AutoConfiguration;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

@SuppressWarnings("removal")
class ForceStringDeserializerRegistrationTest {

  private final ApplicationContextRunner contextRunner = new ApplicationContextRunner()
      .withConfiguration(AutoConfigurations.of(Jackson2AutoConfiguration.class))
      .withUserConfiguration(ForceStringDeserializer.class);

  record Probe(String fileId) {
  }

  @Test
  void bootJackson2ObjectMapperShouldRejectNumbersForStringFields() {
    contextRunner.run(context -> {
      ObjectMapper mapper = context.getBean(ObjectMapper.class);

      assertThat(mapper.readValue("{\"fileId\":\"f1\"}", Probe.class).fileId()).isEqualTo("f1");
      assertThatThrownBy(() -> mapper.readValue("{\"fileId\":1}", Probe.class))
          .isInstanceOf(MismatchedInputException.class)
          .hasMessageContaining("Attempted to parse int to string");
    });
  }
}
