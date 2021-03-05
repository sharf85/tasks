package de.telran;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Main {

    public static void main(String[] args) {
        // task 1
        DateTimeFormatter europeanDateFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate birthday = LocalDate.parse("01.08.1985", europeanDateFormat);

        DateTimeFormatter dayOfWeekFormatter = DateTimeFormatter.ofPattern("EEEE");
        System.out.println("I was born on " + birthday.format(dayOfWeekFormatter));
        System.out.println("The number of the day of year was " + birthday.getDayOfYear());

        LocalDate today = LocalDate.now();
        LocalDate thisYearBirthday = LocalDate.of(today.getYear(), birthday.getMonth(), birthday.getDayOfMonth());

        long daysDiff = Math.abs(ChronoUnit.DAYS.between(today, thisYearBirthday));
        if (today.isAfter(thisYearBirthday)) {
            System.out.println("The birthday is already passed");
            System.out.println(daysDiff + " passed since then");
        } else {
            System.out.println("The birthday is just ahead");
            System.out.println("Only " + daysDiff + " remain to wait");
        }

        // task 2

        int daysToSilvester = today.lengthOfYear() - today.getDayOfYear();
        System.out.println(daysToSilvester + " days remain till New Year");
    }
}
