package com.telran.consumer;

import java.io.PrintWriter;
import java.util.concurrent.BlockingQueue;

public class LineConsumer extends Thread {

    BlockingQueue<String> queue;
    OperationStorage operationStorage;
    PrintWriter pw;

    public LineConsumer(BlockingQueue<String> queue, OperationStorage operationStorage, PrintWriter pw) {
        this.queue = queue;
        this.operationStorage = operationStorage;
        this.pw = pw;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String line = queue.take();
                //TODO: consider possible errors in the line
                String[] splitLine = line.split("#");
                String text = splitLine[0];
                String operationName = splitLine[1];

                IStringOperation operation = operationStorage.getByName(operationName);
                String res = operation.operate(text);
                //TODO: put the res to the file
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
