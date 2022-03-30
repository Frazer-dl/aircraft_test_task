package ru.aircraft.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JsonConfig extends ObjectMapper {
  private static final ObjectMapper mapper = new ObjectMapper();

  public static ObjectMapper getMapper() {
    mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    return mapper;
  }
}
