package com.telran;

import com.telran.queue.ArrayQueue;
import com.telran.queue.FullQueueException;
import com.telran.queue.Queue;

import java.util.Random;

public class QueueGame {

    int capacity;
    Queue<String> queue;
    int probAdd;
    int nMoves;
    Random random = new Random();

    public QueueGame(int capacity, int probAdd, int nMoves) {
        this.capacity = capacity;
        queue = new ArrayQueue<>(capacity);
        this.probAdd = probAdd;
        this.nMoves = nMoves;
    }

    int numOverflow;
    int numEmpty;


    public void play() {
        for (int i = 0; i < nMoves; i++) {
            if (random.nextInt(101) <= probAdd) {
                try {
                    queue.add("won");
                } catch (FullQueueException ex) {
                    numOverflow++;
                }
            } else {
                //надо что-то сделать...
                queue.release();
            }
        }
    }


}
