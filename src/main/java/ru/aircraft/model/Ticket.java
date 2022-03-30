package ru.aircraft.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Ticket implements Serializable {

  private String origin;
  private String originName;
  private String destination;
  private String destinationName;
  private LocalDateTime departure;
  private LocalDateTime arrival;
  private String carrier;
  private Integer stops;
  private Integer price;

}
