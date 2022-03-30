package ru.aircraft.controller;

import java.io.IOException;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.aircraft.service.TicketService;

@Controller
@RequiredArgsConstructor
public class TicketController {

  private static Logger logger = LoggerFactory.getLogger(TicketController.class);

  @Autowired
  private TicketService ticketService;

  @PostConstruct
  public void init() throws IOException {
    logger.info("\n");
    logger.info("\n");
    logger.info(String.format("Average flight time between VVO - TLV is : %s",
        ticketService.getAvgFlightTime("Владивосток", "Тель-Авив")));
    logger.info(String.format("90th percentile flight time between VVO - TLV is : %s",
        ticketService.getPercentile("Владивосток", "Тель-Авив", 90)));
    logger.info("\n");
    logger.info("\n");
  }
}
