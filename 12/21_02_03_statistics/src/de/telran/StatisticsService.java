package de.telran;

import java.time.LocalDateTime;
import java.util.*;

public class StatisticsService {

    /**
     * The method accepts only sorted by time list of statistics.
     *
     * @param statisticsList sorted list by time of statistics
     * @return list with the number of mentions for the corresponding statistics for the last 10 minutes.
     */
    public ArrayList<Integer> last10minutesMentions(List<Statistics> statisticsList) {
        Map<String, Deque<LocalDateTime>> mentionsNumberByUrl = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();

        for (Statistics statistics : statisticsList) {
            Deque<LocalDateTime> deque = mentionsNumberByUrl.get(statistics.getUrl());
            if (deque == null) {
                deque = new ArrayDeque<>();
                mentionsNumberByUrl.put(statistics.getUrl(), deque);
            }

            deque.addLast(statistics.getTime());

            while (deque.getFirst().isBefore(statistics.getTime().minusMinutes(10))) {
                deque.removeFirst();
            }

            res.add(deque.size());
        }
        return res;
    }
}
