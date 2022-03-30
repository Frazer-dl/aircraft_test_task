package ru.aircraft.service;

import java.io.IOException;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.aircraft.mapper.TicketAdapter;
import ru.aircraft.model.Ticket;
import ru.aircraft.repository.JsonRepository;
import ru.aircraft.utils.DateTimeUtils;

@Service
@RequiredArgsConstructor
public class TicketService {

  private final JsonRepository jsonRepository;
  private final TicketAdapter ticketAdapter;

  public List<Ticket> getAll() throws IOException {
    return jsonRepository.getAll().stream()
        .map(ticketAdapter::toTicket)
        .collect(Collectors.toList());
  }

  public LocalTime getAvgFlightTime(String originName, String destinationName) throws IOException {
    double avgMinutes = getAll().stream()
        .filter(t -> t.getOriginName().equals(originName)
            && t.getDestinationName().equals(destinationName))
        .map(ticket -> ChronoUnit.MINUTES.between(ticket.getDeparture(), ticket.getArrival()))
        .mapToLong(l -> l)
        .average().orElse(Double.NaN);

    return DateTimeUtils.doubleToLocalTime(avgMinutes);
  }

  public LocalTime getPercentile(String originName, String destinationName, double percentile)
      throws IOException {
    List<Double> latencies = getAll().stream()
        .filter(t -> t.getOriginName().equals(originName)
            && t.getDestinationName().equals(destinationName))
        .map(ticket -> (double) ChronoUnit.MINUTES.between(ticket.getDeparture(),
            ticket.getArrival()))
        .collect(Collectors.toList());
    return DateTimeUtils.doubleToLocalTime(percentile(latencies, percentile));
  }

  private double percentile(List<Double> latencies, double percentile) {
    Collections.sort(latencies);
    int index = (int) Math.ceil(percentile / 100.0 * latencies.size());
    return latencies.get(index - 1);
  }


}
