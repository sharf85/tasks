package de.telran;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.*;

class MeetingTimeServiceTest {
    MeetingTimeService meeting = new MeetingTimeService();

    LocalDate testingDate = LocalDate.of(2021, Month.MARCH, 5);

    @Test
    public void test_intersectWorkingTime2_intersectionToTheWest() {
        ZoneId zone1 = ZoneId.of("Europe/Berlin");
        ZoneId zone2 = ZoneId.of("America/Costa_Rica");
        LocalTime start1 = LocalTime.of(9, 0);
        LocalTime start2 = LocalTime.of(9, 0);
        Duration res = meeting.intersectWorkingTime(testingDate,
                start1,
                Duration.of(8, ChronoUnit.HOURS),
                zone1,
                start2,
                Duration.of(8, ChronoUnit.HOURS),
                zone2);
        assertEquals(1, res.toHours());

        Duration resRevert = meeting.intersectWorkingTime(testingDate,
                start2,
                Duration.of(8, ChronoUnit.HOURS),
                zone2,
                start1,
                Duration.of(8, ChronoUnit.HOURS),
                zone1);
        assertEquals(1, resRevert.toHours());
    }

    @Test
    public void test_intersectWorkingTime2_intersectionToTheEast() {
        ZoneId zone1 = ZoneId.of("Europe/Berlin");
        ZoneId zone2 = ZoneId.of("Europe/Moscow");
        LocalTime start1 = LocalTime.of(9, 0);
        LocalTime start2 = LocalTime.of(9, 0);
        Duration res = meeting.intersectWorkingTime(testingDate,
                start1,
                Duration.of(8, ChronoUnit.HOURS),
                zone1,
                start2,
                Duration.of(8, ChronoUnit.HOURS),
                zone2);

        assertEquals(6, res.toHours());

        Duration resRevert = meeting.intersectWorkingTime(testingDate,
                start2,
                Duration.of(8, ChronoUnit.HOURS),
                zone2,
                start1,
                Duration.of(8, ChronoUnit.HOURS),
                zone1);
        assertEquals(6, resRevert.toHours());

    }

    @Test
    public void test_intersectWorkingTime2_timeOnBorderOf2Days() {
        ZoneId zone1 = ZoneId.of("Europe/Berlin");
        ZoneId zone2 = ZoneId.of("Europe/Moscow");
        LocalTime start1 = LocalTime.of(22, 0);
        LocalTime start2 = LocalTime.of(23, 0);
        Duration res = meeting.intersectWorkingTime(testingDate,
                start1,
                Duration.of(8, ChronoUnit.HOURS),
                zone1,
                start2,
                Duration.of(9, ChronoUnit.HOURS),
                zone2);

        assertEquals(8, res.toHours());

        Duration resRevert = meeting.intersectWorkingTime(testingDate,
                start2,
                Duration.of(9, ChronoUnit.HOURS),
                zone2,
                start1,
                Duration.of(8, ChronoUnit.HOURS),
                zone1);
        assertEquals(8, resRevert.toHours());

    }

    @Test
    public void test_intersectWorkingTime2_noIntersection() {
        ZoneId zone1 = ZoneId.of("Europe/Berlin");
        ZoneId zone2 = ZoneId.of("Pacific/Honolulu");
        LocalTime start1 = LocalTime.of(9, 0);
        LocalTime start2 = LocalTime.of(8, 0);
        Duration res = meeting.intersectWorkingTime(testingDate,
                start1,
                Duration.of(8, ChronoUnit.HOURS),
                zone1,
                start2,
                Duration.of(9, ChronoUnit.HOURS),
                zone2);

        assertEquals(0, res.toHours());

        Duration resRevert = meeting.intersectWorkingTime(testingDate,
                start2,
                Duration.of(9, ChronoUnit.HOURS),
                zone2,
                start1,
                Duration.of(8, ChronoUnit.HOURS),
                zone1);
        assertEquals(0, resRevert.toHours());

    }

    @Test
    public void test_intersectWorkingTime2_borderCase() {
        ZoneId zone1 = ZoneId.of("US/Alaska");
        ZoneId zone2 = ZoneId.of("Asia/Kamchatka");
        LocalTime start1 = LocalTime.of(9, 0);
        LocalTime start2 = LocalTime.of(9, 0);
        Duration res = meeting.intersectWorkingTime(testingDate,
                start1,
                Duration.of(8, ChronoUnit.HOURS),
                zone1,
                start2,
                Duration.of(8, ChronoUnit.HOURS),
                zone2);

        assertEquals(5, res.toHours());

        Duration resRevert = meeting.intersectWorkingTime(testingDate,
                start2,
                Duration.of(8, ChronoUnit.HOURS),
                zone2,
                start1,
                Duration.of(8, ChronoUnit.HOURS),
                zone1);
        assertEquals(5, resRevert.toHours());

    }

    @Test
    public void test_intersectWorkingTime2_borderCase_ViceVersa() {
        ZoneId zone1 = ZoneId.of("Asia/Kamchatka");
        ZoneId zone2 = ZoneId.of("US/Alaska");
        LocalTime start1 = LocalTime.of(9, 0);
        LocalTime start2 = LocalTime.of(9, 0);
        Duration res = meeting.intersectWorkingTime(testingDate,
                start1,
                Duration.of(8, ChronoUnit.HOURS),
                zone1,
                start2,
                Duration.of(8, ChronoUnit.HOURS),
                zone2);

        assertEquals(5, res.toHours());

        Duration resRevert = meeting.intersectWorkingTime(testingDate,
                start2,
                Duration.of(8, ChronoUnit.HOURS),
                zone2,
                start1,
                Duration.of(8, ChronoUnit.HOURS),
                zone1);
        assertEquals(5, resRevert.toHours());

    }

    @Test
    public void test_intersectWorkingTime2_sameTimeZone() {
        ZoneId zone1 = ZoneId.of("Europe/Berlin");
        ZoneId zone2 = ZoneId.of("Europe/Warsaw");
        LocalTime start1 = LocalTime.of(9, 0);
        LocalTime start2 = LocalTime.of(9, 0);
        Duration res = meeting.intersectWorkingTime(testingDate,
                start1,
                Duration.of(8, ChronoUnit.HOURS),
                zone1,
                start2,
                Duration.of(8, ChronoUnit.HOURS),
                zone2);

        assertEquals(8, res.toHours());

        Duration resRevert = meeting.intersectWorkingTime(testingDate,
                start2,
                Duration.of(8, ChronoUnit.HOURS),
                zone2,
                start1,
                Duration.of(8, ChronoUnit.HOURS),
                zone1);
        assertEquals(8, resRevert.toHours());

    }
}
