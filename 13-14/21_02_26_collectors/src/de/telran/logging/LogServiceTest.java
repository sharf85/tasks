package de.telran.logging;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LogServiceTest {
    LogService logEntryService = new LogService();

    LogEntry logEntry1 = new LogEntry("user1", "link1");
    LogEntry logEntry3 = new LogEntry("user2", "link1");
    LogEntry logEntry4 = new LogEntry("user3", "link1");
    LogEntry logEntry6 = new LogEntry("user3", "link1");
    LogEntry logEntry2 = new LogEntry("user1", "link2");
    LogEntry logEntry5 = new LogEntry("user4", "link2");

    List<LogEntry> entries = Arrays.asList(logEntry1, logEntry2, logEntry3, logEntry4, logEntry5, logEntry6);


    @Test
    public void countUrlVisits_Test() {
        Map<String, Long> result = logEntryService.getClicksByUrl(entries);
        assertEquals(4, result.get("link1"));
        assertEquals(2, result.get("link2"));
    }

    @Test
    public void countUniqUrlVisits_Test() {
        Map<String, Integer> result = logEntryService.getUniqLoginsByUrl(entries);
        assertEquals(3, result.get("link1"));
        assertEquals(2, result.get("link2"));
    }
}
