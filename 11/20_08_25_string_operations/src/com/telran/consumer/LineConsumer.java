package com.telran.consumer;

import java.io.PrintWriter;
import java.util.concurrent.BlockingQueue;
//import java.util.concurrent.atomic.AtomicBoolean;

public class LineConsumer extends Thread {

    public static final String STOP_COMMAND = "stop_word";
    final BlockingQueue<String> queue;
    final OperationStorage operationStorage;
    final PrintWriter pw;
//    final AtomicBoolean isAlive;

    public LineConsumer(BlockingQueue<String> queue,
                        OperationStorage operationStorage,
                        PrintWriter pw) {
        this.queue = queue;
        this.operationStorage = operationStorage;
        this.pw = pw;
//        this.isAlive = isAlive;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String line = queue.take();
//                synchronized (isAlive) {
//                    if (!isAlive.get() && queue.isEmpty())
//                        return;
//                    line = queue.take();
//                }

                if (line.equals(STOP_COMMAND))
                    return;
                //TODO: consider possible errors in the line
//                String[] splitLine = line.split("#");
//                String text = splitLine[0];
//                String operationName = splitLine[1];
//
//                IStringOperation operation = operationStorage.getByName(operationName);
//                String res = operation.operate(text);
                //TODO: put the res to the file
                pw.println(line);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
