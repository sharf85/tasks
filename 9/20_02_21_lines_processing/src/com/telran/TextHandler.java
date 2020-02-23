package com.telran;

import java.util.Deque;

public class TextHandler extends Thread {

    private OperationProvider op;
    private Deque<String> deque;
    private String delimiter;

    public TextHandler(OperationProvider op, Deque<String> deque, String delimiter) {
        this.op = op;
        this.deque = deque;
        this.delimiter = delimiter;
    }

    @Override
    public void run() {
        while (true) {
            String line = deque.pollLast();
            if (line == null)
                return;
            String[] parts = line.split(delimiter);
            //TODO verify the parts - look into the Calculator project
            String text = parts[0];
            String operationName = parts[1];
            IOperation operation = op.getByName(operationName);
            //TODO compute the result and write it into a file
        }
    }
}
