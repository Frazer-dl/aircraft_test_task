package ru.aircraft.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TicketDto implements Serializable {
  @JsonProperty
  private String origin;
  @JsonProperty("origin_name")
  private String originName;
  @JsonProperty
  private String destination;
  @JsonProperty("destination_name")
  private String destinationName;
  @JsonProperty("departure_date")
  private String departureDate;
  @JsonProperty("departure_time")
  private String departureTime;
  @JsonProperty("arrival_date")
  private String arrivalDate;
  @JsonProperty("arrival_time")
  private String arrivalTime;
  @JsonProperty
  private String carrier;
  @JsonProperty
  private String stops;
  @JsonProperty
  private String price;

}
