package com.telran.handler;

import com.telran.service.FileService;

import java.util.concurrent.BlockingDeque;

public class TextHandler implements Runnable {

    private static final String INCORRECT_LINE = "Incorrect line";
    private static final String WRONG_OPERATION = "Wrong operation";
    private String delimiter = "#";

    private final FileService fileService;
    private OperationProvider op;
    private BlockingDeque<String> lines;

    private volatile static boolean isAlive = true;

    public TextHandler(OperationProvider op, BlockingDeque<String> lines, FileService fileService) {
        this.op = op;
        this.lines = lines;
        this.fileService = fileService;
    }

    @Override
    public void run() {
        while (isAlive) {
            String line;
            try {
                line = lines.takeFirst();
            } catch (InterruptedException e) {
                return;
            }
            if (line.equals("exit")) {
                isAlive = false;
                return;
            }

            String[] parts = line.split(delimiter);

            String result;
            if (parts.length != 2) {
                result = line + delimiter + INCORRECT_LINE;
            } else {
                String text = parts[0];
                String operationName = parts[1];
                IOperation operation = op.getByName(operationName);
                if (operation == null)
                    result = line + delimiter + WRONG_OPERATION;
                else
                    result = operation.operate(text);
            }

            fileService.println(result);
        }
    }
}
