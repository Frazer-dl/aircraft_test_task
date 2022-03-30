package ru.aircraft.repository;

import com.fasterxml.jackson.databind.json.JsonMapper;
import java.io.IOException;
import java.util.List;
import org.springframework.stereotype.Repository;
import ru.aircraft.dto.TicketDto;
import ru.aircraft.utils.JsonUtils;

@Repository
public class JsonRepository {

  public List<TicketDto> getAll() throws IOException {
    JsonUtils.setMapper(new JsonMapper());
    return JsonUtils.readValues(JsonUtils.getInputStream(), TicketDto[].class);
  }
}
