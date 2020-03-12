package com.telran;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class DateService {
    public int getInterval(int startA, int endA, String zoneA, int startB, int endB, String zoneB) {
        ZonedDateTime startADateTime =
                ZonedDateTime.of(LocalDate.now(), LocalTime.of(startA, 0), ZoneId.of(zoneA));
        ZonedDateTime endADateTime =
                ZonedDateTime.of(LocalDate.now(), LocalTime.of(endA, 0), ZoneId.of(zoneA));

        ZonedDateTime startBDateTime =
                ZonedDateTime.of(LocalDate.now(), LocalTime.of(startB, 0), ZoneId.of(zoneB));
        ZonedDateTime endBDateTime =
                ZonedDateTime.of(LocalDate.now(), LocalTime.of(endB, 0), ZoneId.of(zoneB));

        int res = intersectTwoTimeIntervals(startADateTime, endADateTime, startBDateTime, endBDateTime);
        if (res > 0) {
            return res;
        }

        ZonedDateTime startBDateTimeTomorrow = startBDateTime.plus(1, ChronoUnit.DAYS);
        ZonedDateTime endBDateTimeTomorrow = endBDateTime.plus(1, ChronoUnit.DAYS);

        res = intersectTwoTimeIntervals(startADateTime, endADateTime, startBDateTimeTomorrow, endBDateTimeTomorrow);
        if (res > 0) {
            return res;
        }

        ZonedDateTime startBDateTimeYesterday = startBDateTime.minus(1, ChronoUnit.DAYS);
        ZonedDateTime endBDateTimeYesterday = endBDateTime.minus(1, ChronoUnit.DAYS);

        res = intersectTwoTimeIntervals(startADateTime, endADateTime, startBDateTimeYesterday, endBDateTimeYesterday);

        return res;
    }

    /**
     * The function finds the intersection of two time intervals given the first one is before
     * the second one (startADateTime < startBDateTime)
     *
     * @return the number of hours
     */
    int intersectTwoTimeIntervals(
            ZonedDateTime startADateTime,
            ZonedDateTime endADateTime,
            ZonedDateTime startBDateTime,
            ZonedDateTime endBDateTime
    ) {
        if (isBetween(startBDateTime, startADateTime, endADateTime)) {
            if (isBetween(endBDateTime, startBDateTime, endADateTime))
                return (int) ChronoUnit.HOURS.between(startBDateTime, endBDateTime);
            else
                return (int) ChronoUnit.HOURS.between(startBDateTime, endADateTime);
        } else if (isBetween(startADateTime, startBDateTime, endBDateTime)) {
            if (isBetween(endADateTime, startADateTime, endBDateTime))
                return (int) ChronoUnit.HOURS.between(startADateTime, endADateTime);
            else
                return (int) ChronoUnit.HOURS.between(startADateTime, endBDateTime);
        }
        return 0;
    }

    boolean isBetween(ZonedDateTime needle, ZonedDateTime start, ZonedDateTime end) {
        return !needle.isBefore(start) && !needle.isAfter(end);
    }
}
