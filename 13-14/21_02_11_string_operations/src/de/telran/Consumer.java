package de.telran;

import de.telran.operation.IStringOperation;
import de.telran.operation.OperationContext;

import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {


    public static final String SEPARATOR = "#";
    public static final String WRONG_FORMAT = "wrong format";
    public static final String WRONG_OPERATION = "wrong operation";
    private final BlockingQueue<String> queue;
    private final PrintWriter writer;
    private final OperationContext context;

    public Consumer(BlockingQueue<String> queue, PrintWriter writer, OperationContext context) {
        this.queue = queue;
        this.writer = writer;
        this.context = context;
    }

    @Override
    public void run() {

        boolean isAlive = true;

        while (isAlive) {
            try {
                System.out.println(queue.size());
                String line = queue.take();
                String resLine = handleRawString(line);
                writer.println(resLine);
            } catch (InterruptedException e) {
                isAlive = false;
            }
        }

        // finish the queue
        while (true) {
            String line;

            try {
                line = queue.remove();
            } catch (NoSuchElementException e) {
                e.printStackTrace();
                break;
            }

            String resLine = handleRawString(line);
            writer.println(resLine);
        }
    }

    String handleRawString(String line) {
        String[] result = line.split(SEPARATOR);

        if (result.length != 2)
            return line + SEPARATOR + WRONG_FORMAT;

        String stringToPerform = result[0];
        String operationName = result[1];

        IStringOperation stringOperation = context.getOperation(operationName);

        if (stringOperation == null)
            return line + SEPARATOR + WRONG_OPERATION;

        return stringOperation.operate(stringToPerform);
    }
}
