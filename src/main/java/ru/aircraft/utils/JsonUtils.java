package ru.aircraft.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lombok.experimental.UtilityClass;
import org.springframework.util.ResourceUtils;
import ru.aircraft.config.JsonConfig;
import ru.aircraft.model.Ticket;

@UtilityClass
public class JsonUtils {

  private static ObjectMapper mapper = JsonConfig.getMapper();

  public static void setMapper(ObjectMapper mapper) {
    JsonUtils.mapper = mapper;
  }

  public static <T> List<T> readValues(InputStream json, Class<T[]> clazz)
      throws IOException {
    JsonNode node = mapper.readTree(json);
    JsonParser parser = mapper.treeAsTokens(node.get("tickets"));
    try {
      return Arrays.stream(mapper.readValue(parser, clazz))
          .collect(Collectors.toList());
    } catch (IOException e) {
      throw new IllegalArgumentException("Invalid read array from JSON:\n'" + json + "'", e);
    }
  }

  public static InputStream getInputStream() {
    return Ticket.class.getResourceAsStream("/" + "tickets.json");
  }
}
