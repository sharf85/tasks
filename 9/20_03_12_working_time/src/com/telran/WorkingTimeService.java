package com.telran;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class WorkingTimeService {

    public int getCommonInterval(
            int start1,
            int end1,
            String zone1,
            int start2,
            int end2,
            String zone2
    ) {

        ZonedDateTime startTime1 = ZonedDateTime.of(LocalDate.now(), LocalTime.of(start1, 0), ZoneId.of(zone1));
        ZonedDateTime endTime1 = ZonedDateTime.of(LocalDate.now(), LocalTime.of(end1, 0), ZoneId.of(zone1));
        ZonedDateTime startTime2 = ZonedDateTime.of(LocalDate.now(), LocalTime.of(start2, 0), ZoneId.of(zone2));
        ZonedDateTime endTime2 = ZonedDateTime.of(LocalDate.now(), LocalTime.of(end2, 0), ZoneId.of(zone2));

        int res = intersectIntervals(startTime1, endTime1, startTime2, endTime2);

        if (res > 0)
            return res;

        ZonedDateTime startTime2Tomorrow = startTime2.plus(1, ChronoUnit.DAYS);
        ZonedDateTime endTime2Tomorrow = endTime2.plus(1, ChronoUnit.DAYS);

        res = intersectIntervals(startTime1, endTime1, startTime2Tomorrow, endTime2Tomorrow);

        if (res > 0)
            return res;

        ZonedDateTime startTime2Yesterday = startTime2.minus(1, ChronoUnit.DAYS);
        ZonedDateTime endTime2Yesterday = endTime2.minus(1, ChronoUnit.DAYS);

        res = intersectIntervals(startTime1, endTime1, startTime2Yesterday, endTime2Yesterday);
        return res;

    }

    int intersectIntervals(
            ZonedDateTime startTime1,
            ZonedDateTime endTime1,
            ZonedDateTime startTime2,
            ZonedDateTime endTime2) {

        if (isBetween(startTime2, startTime1, endTime1)) {
            return intersectIntervalsStartingFirst(
                    startTime1,
                    endTime1,
                    startTime2,
                    endTime2);
        } else if (isBetween(startTime1, startTime2, endTime2)) {
            return intersectIntervalsStartingFirst(
                    startTime2,
                    endTime2,
                    startTime1,
                    endTime1);

        }
        return 0;
    }

    private int intersectIntervalsStartingFirst(
            ZonedDateTime startTime1,
            ZonedDateTime endTime1,
            ZonedDateTime startTime2,
            ZonedDateTime endTime2) {
        if (isBetween(endTime1, startTime2, endTime2))
            return (int) ChronoUnit.HOURS.between(startTime2, endTime1);
        else
            return (int) ChronoUnit.HOURS.between(startTime2, endTime2);
    }

    boolean isBetween(ZonedDateTime needle, ZonedDateTime start, ZonedDateTime end) {
        return !start.isAfter(needle) && !end.isBefore(needle);
    }

}
