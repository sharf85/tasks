package com.telran;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.*;

public class Main {

    public static void main(String[] args) {
        LogEntry log1 = new LogEntry("url1", "user1");
        LogEntry log2 = new LogEntry("url2", "user4");
        LogEntry log3 = new LogEntry("url2", "user5");
        LogEntry log4 = new LogEntry("url2", "user2");
        LogEntry log5 = new LogEntry("url5", "user1");
        LogEntry log6 = new LogEntry("url5", "user1");
        LogEntry log7 = new LogEntry("url1", "user3");
        LogEntry log8 = new LogEntry("url3", "user2");
        LogEntry log9 = new LogEntry("url4", "user6");
        LogEntry log10 = new LogEntry("url3", "user7");

        List<LogEntry> logs = Arrays.asList(
                log1,
                log2,
                log3,
                log4,
                log5,
                log6,
                log7,
                log8,
                log9,
                log10);

        // count number of visits
        Map<String, Long> visitByUrl = logs.stream()
                .parallel()
                .collect(groupingBy(LogEntry::getUrl, counting()));
        System.out.println(visitByUrl);

        // count numbers of unique users per url
        Map<String, Integer> usersByUrl = logs
                .stream()
                .collect(
                        groupingBy(
                                LogEntry::getUrl,
                                mapping(LogEntry::getUsername,
                                        new DistinctCountingCollector<>()
                                )
                        )
                );

        System.out.println(usersByUrl);


        Map<String, Integer> usersByUrl2 = logs
                .stream()
                .collect(
                        groupingBy(
                                LogEntry::getUrl,
                                mapping(LogEntry::getUsername,
                                        collectingAndThen(toSet(), Set::size)
                                )
                        )
                );

        System.out.println(usersByUrl2);

        Map<String, Set<String>> usersByUrl3 = logs
                .stream()
                .collect(
                        groupingBy(
                                LogEntry::getUrl,
                                mapping(LogEntry::getUsername,
                                        toSet()
                                )
                        )
                );

        System.out.println(usersByUrl3);

    }
}
