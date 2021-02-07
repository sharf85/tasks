package de.telran;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StatisticsServiceTest {
    List<Statistics> listOfStatistics = new ArrayList<>();
    StatisticsService ss = new StatisticsService();


    @Test
    public void test_last10minutesMentions() {


        Statistics one = new Statistics(LocalDateTime.of(LocalDate.now(), LocalTime.of(9, 0)), "url1");
        Statistics two = new Statistics(LocalDateTime.of(LocalDate.now(), LocalTime.of(9, 1)), "url2");
        Statistics three = new Statistics(LocalDateTime.of(LocalDate.now(), LocalTime.of(9, 3)), "url1");
        Statistics four = new Statistics(LocalDateTime.of(LocalDate.now(), LocalTime.of(9, 3)), "url2");
        Statistics five = new Statistics(LocalDateTime.of(LocalDate.now(), LocalTime.of(9, 15)), "url2");
        Collections.addAll(listOfStatistics, one, two, three, four, five);
        List<Integer> res = ss.last10minutesMentions(listOfStatistics);
        List<Integer> expected = Arrays.asList(1, 1, 2, 2, 1);

        assertEquals(expected, res);
    }

    @Test
    public void test_last10minutesMentions_exp1_differentKeys() {
        Statistics one = new Statistics(LocalDateTime.of(LocalDate.now(), LocalTime.of(9, 0)), "url1");
        Statistics two = new Statistics(LocalDateTime.of(LocalDate.now(), LocalTime.of(9, 1)), "url2");
        Statistics three = new Statistics(LocalDateTime.of(LocalDate.now(), LocalTime.of(9, 3)), "url3");
        Statistics four = new Statistics(LocalDateTime.of(LocalDate.now(), LocalTime.of(9, 3)), "url4");
        Statistics five = new Statistics(LocalDateTime.of(LocalDate.now(), LocalTime.of(9, 15)), "url2");
        Collections.addAll(listOfStatistics, one, two, three, four, five);
        List<Integer> res = ss.last10minutesMentions(listOfStatistics);
        List<Integer> expected = Arrays.asList(1, 1, 1, 1, 1);

        assertEquals(expected, res);
    }

    @Test
    public void test_last10minutesMentions_anotherStatistics_exp1_greaterThen10Minutes() {
        Statistics one = new Statistics(LocalDateTime.of(LocalDate.now(), LocalTime.of(8, 50)), "url1");
        Statistics two = new Statistics(LocalDateTime.of(LocalDate.now(), LocalTime.of(9, 1)), "url1");
        Statistics three = new Statistics(LocalDateTime.of(LocalDate.now(), LocalTime.of(9, 30)), "url1");
        Statistics four = new Statistics(LocalDateTime.of(LocalDate.now(), LocalTime.of(17, 33)), "url2");
        Statistics five = new Statistics(LocalDateTime.of(LocalDate.now(), LocalTime.of(17, 44)), "url2");
        Collections.addAll(listOfStatistics, one, two, three, four, five);
        List<Integer> res = ss.last10minutesMentions(listOfStatistics);
        List<Integer> expected = Arrays.asList(1, 1, 1, 1, 1);

        assertEquals(expected, res);
    }

    @Test
    public void test_last10minutesMentions_timeBeforeAndAfterFullHour() {
        Statistics one = new Statistics(LocalDateTime.of(LocalDate.now(), LocalTime.of(8, 55)), "url1");
        Statistics two = new Statistics(LocalDateTime.of(LocalDate.now(), LocalTime.of(9, 1)), "url1");
        Statistics three = new Statistics(LocalDateTime.of(LocalDate.now(), LocalTime.of(9, 3)), "url1");
        Statistics four = new Statistics(LocalDateTime.of(LocalDate.now(), LocalTime.of(12, 51)), "url2");
        Statistics five = new Statistics(LocalDateTime.of(LocalDate.now(), LocalTime.of(13, 1)), "url2");
        Collections.addAll(listOfStatistics, one, two, three, four, five);
        List<Integer> res = ss.last10minutesMentions(listOfStatistics);
        List<Integer> expected = Arrays.asList(1, 2, 3, 1, 2);

        assertEquals(expected, res);
    }

}
