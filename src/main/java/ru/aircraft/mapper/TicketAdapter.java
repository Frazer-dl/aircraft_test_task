package ru.aircraft.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.aircraft.dto.TicketDto;
import ru.aircraft.model.Ticket;
import ru.aircraft.utils.DateTimeUtils;

@Mapper(componentModel = "spring", imports = {DateTimeUtils.class, Integer.class})
public interface TicketAdapter {

  @Mapping(target = "departure",
      expression = "java(DateTimeUtils.toDateTime(dto.getDepartureDate(), dto.getDepartureTime()))")
  @Mapping(target = "arrival",
      expression = "java(DateTimeUtils.toDateTime(dto.getArrivalDate(), dto.getArrivalTime()))")
  @Mapping(target = "stops", expression = "java(Integer.parseInt(dto.getStops()))")
  @Mapping(target = "price", expression = "java(Integer.parseInt(dto.getPrice()))")
  Ticket toTicket(TicketDto dto);
}
