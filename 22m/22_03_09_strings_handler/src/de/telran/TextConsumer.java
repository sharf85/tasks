package de.telran;

import java.io.PrintWriter;
import java.util.concurrent.BlockingQueue;

public class TextConsumer implements Runnable {

    private final BlockingQueue<String> queue;
    private final OperationContext operationContext;
    private final PrintWriter pw;

    public TextConsumer(BlockingQueue<String> queue, OperationContext operationContext, PrintWriter pw) {
        this.queue = queue;
        this.operationContext = operationContext;
        this.pw = pw;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String line = queue.take();
                String newLine = handleLine(line);
                pw.println(newLine);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String handleLine(String line) {
        // TODO implement
        String operationName;
        String text;
        // TODO fill the variables operationName and text. Check whether the format of the line is correct

        IStringOperation operation = operationContext.getOperation(operationName);
        // Check whether the operation exists
        String res = operation.operate(text);

        return res;
    }
}
