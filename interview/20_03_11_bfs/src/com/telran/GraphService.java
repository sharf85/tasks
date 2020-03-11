package com.telran;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class GraphService {

    public int getDistance(List<List<Integer>> graph, int start, int end) {
        int size = graph.size();
        int[] distance = new int[size];

        Deque<Integer> processingQueue = new ArrayDeque<>();

        processingQueue.addLast(start);

        while (processingQueue.size() > 0) {
            int currentVertex = processingQueue.removeFirst();

            List<Integer> neighbours = graph.get(currentVertex);
            for (int neighbour : neighbours) {
                if (distance[neighbour] == 0 && neighbour != start) {
                    distance[neighbour] = distance[currentVertex] + 1;
                    processingQueue.addLast(neighbour);
                }
            }
        }

        return distance[end];
    }
}
