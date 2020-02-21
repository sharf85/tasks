package com.telran;

import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.CopyOnWriteArrayList;

public class TextHandler implements Runnable {

    private String delimiter = "#";
    private OperationProvider op;
    private Deque<String> lines;

    public TextHandler(OperationProvider op, Deque<String> lines) {
        this.op = op;
        this.lines = lines;
    }

    @Override
    public void run() {
        while (true) {
            String line = lines.pollLast();
            if (line == null)
                return;

            String[] parts = line.split(delimiter);
            //TODO check edge cases
            String text = parts[0];
            String operationName = parts[1];
            IOperation operation = op.getByName(operationName);
            String result = operation.operate(text);
            //TODO write this into a file
        }
    }
}
