package de.telran.logging;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.*;

public class LogService {

    public Map<String, Long> getClicksByUrl(List<LogEntry> logs) {
        return logs.stream()
                .collect(groupingBy(LogEntry::getUrl, counting()));
    }

    public Map<String, Integer> getUniqLoginsByUrl(List<LogEntry> logs) {
        return logs.stream()
                .collect(groupingBy(LogEntry::getUrl, mapping(LogEntry::getLogin,
                        collectingAndThen(toSet(), Set::size))));
    }
}
