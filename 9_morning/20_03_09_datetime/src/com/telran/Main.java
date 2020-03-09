package com.telran;

import java.time.LocalDate;
import java.time.Period;
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

    }
}
