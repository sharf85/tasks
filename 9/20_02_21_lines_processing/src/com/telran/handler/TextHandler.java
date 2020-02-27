package com.telran.handler;

import com.telran.service.FileService;

import java.util.Deque;

public class TextHandler extends Thread {

    private static final String INCORRECT_LINE = "Incorrect line";
    private static final String INCORRECT_OPERATION = "Incorrect operation";

    private OperationProvider op;
    private Deque<String> deque;
    private String delimiter;
    private FileService fs;

    public TextHandler(OperationProvider op, Deque<String> deque, String delimiter, FileService fs) {
        this.op = op;
        this.deque = deque;
        this.delimiter = delimiter;
        this.fs = fs;
    }

    @Override
    public void run() {
        while (true) {
            String line = deque.pollFirst();
            if (line == null)
                return;
            String[] parts = line.split(delimiter);

            String result;
            if (parts.length != 2) {
                result = line + delimiter + INCORRECT_LINE;
            } else {
                String text = parts[0];
                String operationName = parts[1];
                IOperation operation = op.getByName(operationName);
                if (operation == null)
                    result = line + delimiter + INCORRECT_OPERATION;
                else
                    result = operation.operate(text);
            }
            fs.println(result);
        }
    }
}
