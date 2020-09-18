package com.telran;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

import static java.util.stream.Collectors.*;

public class LogEntryService {

    public Map<String, Long> getAttendanceByUrl(List<LogEntry> logs) {
        return logs.stream()
                .collect(groupingBy(LogEntry::getUrl, counting()));
    }

    public Map<String, Integer> getUniqueUsersNumberByUrl(List<LogEntry> logs) {

        Function<LogEntry, String> getUsername = logEntry -> logEntry.getUsername();
        DistinctCountingBy<LogEntry, String> countingBy = new DistinctCountingBy<>(getUsername);

        return logs.stream()
                .collect(groupingBy(LogEntry::getUrl, countingBy
                ));
    }
}
