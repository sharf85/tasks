package com.telran;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Main {

    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println(today.toString());
        //the same
        System.out.println(today.format(DateTimeFormatter.ISO_DATE));

        // formatters
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        System.out.println(today.format(formatter));
        LocalDate dr = LocalDate.parse("1985/08/01", formatter);
        System.out.println(dr.format(DateTimeFormatter.ofPattern("dd.MM.yy")));
        System.out.println(dr.format(formatter));
        System.out.println(dr);

        // periods
        LocalDate drThisYear = LocalDate.of(LocalDate.now().getYear(), Month.AUGUST, 1);
        System.out.println("The hb already was: " + drThisYear.isBefore(today));

        LocalDate newYearDate = LocalDate.of(today.getYear(), 12, 31);
        LocalDateTime newYear = LocalDateTime.of(newYearDate, LocalTime.of(10, 0));

        LocalDateTime todayWithTime = LocalDateTime.now();
        Duration todayBetweenNY = Duration.between(todayWithTime, newYear);
        System.out.println(todayBetweenNY.toDays());
        System.out.println(ChronoUnit.DAYS.between(todayWithTime, newYear));

        // zoned date time

        ZonedDateTime zonedNow = ZonedDateTime.of(todayWithTime, ZoneId.systemDefault());
        System.out.println(zonedNow);

        ZonedDateTime zonedNowMoscow = zonedNow.withZoneSameInstant(ZoneId.of("Europe/Moscow"));
        System.out.println(zonedNowMoscow);

        ZonedDateTime zonedNowMoscowWrong = ZonedDateTime.of(todayWithTime, ZoneId.of("Europe/Moscow"));
        System.out.println(zonedNowMoscowWrong);
    }
}
