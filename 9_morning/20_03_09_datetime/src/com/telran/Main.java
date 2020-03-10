package com.telran;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;


public class Main {

    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println(today);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy");
        System.out.println(today.format(formatter));

//        LocalDate tomorrow = today.plus(Period.ofDays(1));
        LocalDate nextMonth = today.plus(31, ChronoUnit.DAYS);
        System.out.println(nextMonth);

        Period todayAndNextMonth = Period.between(today, nextMonth);
        System.out.println(todayAndNextMonth);

        LocalDate yesterday = today.minus(Period.ofDays(1));
        System.out.println(today.getDayOfWeek().getValue());
        System.out.println(yesterday.getDayOfWeek().getValue());

        //LocalTime
        LocalTime now = LocalTime.now();
        LocalTime start = LocalTime.of(10, 0);

        long seconds = ChronoUnit.SECONDS.between(start, now);

        Duration duration = Duration.between(start, now);
        System.out.println(duration.get(ChronoUnit.SECONDS));
        System.out.println(duration.getSeconds());

        System.out.println(seconds);

        // LocalDateTime
        LocalDateTime dateTime = LocalDate.now().atStartOfDay();
        LocalDateTime lessonStart = LocalDate.now().atTime(10, 0);

        // ZonedDateTime

        ZonedDateTime zDate = ZonedDateTime.now();
        System.out.println(zDate);

        ZonedDateTime zDateMoscow = ZonedDateTime.now(ZoneId.of("Europe/Moscow"));
        System.out.println(zDateMoscow);

        ZonedDateTime zDateMoscowWrong = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("Europe/Moscow"));
        System.out.println(zDateMoscowWrong);

        System.out.println(ZoneId.getAvailableZoneIds());

        ZonedDateTime zNewYork = zDateMoscow.withZoneSameInstant(ZoneId.of("America/New_York"));
        System.out.println(zNewYork);

        //
        LocalDate todayDay = LocalDate.now();
        ZonedDateTime vladivostokTime = ZonedDateTime.of(todayDay, LocalTime.of(18, 0), ZoneId.of("Asia/Vladivostok"));
        ZonedDateTime moscowTime = ZonedDateTime.of(todayDay, LocalTime.of(8, 0), ZoneId.of("Europe/Moscow"));

        if (moscowTime.isBefore(vladivostokTime)) {
            System.out.println(moscowTime + " comes before " + vladivostokTime);
        } else {
            System.out.println(vladivostokTime + " comes before " + moscowTime);
        }
    }
}
