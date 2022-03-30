package ru.aircraft.utils;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DateTimeUtils {

  public static LocalDateTime toDateTime(String date, String time) {
    time = Arrays.asList(time.split(":")).get(0).length() == 1 ? "0" + time : time;
    String str = date + " " + time;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy HH:mm");
    return LocalDateTime.parse(str, formatter);
  }

  public static LocalTime doubleToLocalTime(double time) {
    return LocalTime.of((int) time / 60, (int) time % 60);
  }
}
