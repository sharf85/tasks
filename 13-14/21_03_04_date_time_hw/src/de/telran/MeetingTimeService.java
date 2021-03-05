package de.telran;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class MeetingTimeService {

    /**
     * The method estimates the time interval which is common for both zones
     *
     * @param currentDate the date in the zone 1
     * @param startTime1   the start time of work in the zone 1
     * @param duration1    the duration of work in zone 1
     * @param zoneId1      the zone 1
     * @param startTime2   the start time of work in the zone 2
     * @param duration2    the duration of work in zone 2
     * @param zoneId2      the zone 2
     * @return the duration of possible common time interval
     */
    public Duration intersectWorkingTime(
            LocalDate currentDate,
            LocalTime startTime1,
            Duration duration1,
            ZoneId zoneId1,
            LocalTime startTime2,
            Duration duration2,
            ZoneId zoneId2
    ) {
        ZonedDateTime start1 = ZonedDateTime.of(currentDate, startTime1, zoneId1);
        ZonedDateTime end1 = start1.plus(duration1);

        ZonedDateTime start2today = ZonedDateTime.of(currentDate, startTime2, zoneId2);
        ZonedDateTime end2today = start2today.plus(duration2);

        ZonedDateTime start2yesterday = start2today.minus(1, ChronoUnit.DAYS);
        ZonedDateTime end2yesterday = start2yesterday.plus(duration2);


        ZonedDateTime start2tomorrow = start2today.plus(1, ChronoUnit.DAYS);
        ZonedDateTime end2tomorrow = start2tomorrow.plus(duration2);

        Duration resYesterday = intersect(start1, end1, start2yesterday, end2yesterday);
        Duration resToday = intersect(start1, end1, start2today, end2today);
        Duration resTomorrow = intersect(start1, end1, start2tomorrow, end2tomorrow);

        Duration res = resYesterday.plus(resToday).plus(resTomorrow);
        return res;
    }

    private Duration intersect(ZonedDateTime start1,
                               ZonedDateTime end1,
                               ZonedDateTime start2,
                               ZonedDateTime end2) {

        ZonedDateTime start = start1.isBefore(start2) ? start2 : start1;
        ZonedDateTime end = end1.isBefore(end2) ? end1 : end2;

        Duration res = Duration.between(start, end);
        return res.isNegative() ? Duration.ZERO : res;
    }
}
