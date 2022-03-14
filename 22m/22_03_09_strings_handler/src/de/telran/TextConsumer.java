package de.telran;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.concurrent.BlockingQueue;

public class TextConsumer extends Thread {

    private final BlockingQueue<String> queue;
    private final OperationContext operationContext;
    private final PrintWriter pw;
    private Thread nextConsumerThread;

    public TextConsumer(BlockingQueue<String> queue, OperationContext operationContext, PrintWriter pw) {
        this.queue = queue;
        this.operationContext = operationContext;
        this.pw = pw;
    }

    public void setNextConsumerThread(Thread nextConsumerThread) {
        this.nextConsumerThread = nextConsumerThread;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String line = queue.take();

                if (line.equals("exit")) {
                    nextConsumerThread.interrupt();
                    return;
                }

                String newLine = handleLine(line);
                pw.println(newLine);
            }
        } catch (InterruptedException e) {
            nextConsumerThread.interrupt();
            System.err.println(Thread.currentThread().getId() + " interrupted");
        }
    }

    private String handleLine(String line) {

        String[] parts = line.split("#");
        if (parts.length != 2) {
            return line + "#" + "wrong format";
        }

        String operationName = parts[0];
        String text = parts[1];

        IStringOperation operation = operationContext.getOperation(operationName);

        if (operation == null)
            return line + "#" + "operation not supported";

        return operation.operate(text);
    }
}
