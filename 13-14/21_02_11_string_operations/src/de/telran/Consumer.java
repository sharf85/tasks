package de.telran;

import de.telran.operation.OperationContext;

import java.io.PrintWriter;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

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
        // TODO 1. read a line from the queue
        // TODO 2. call the method 'handleRawString'
        // TODO 3. write the resulting string into the 'writer'
    }

    String handleRawString(String line) {
        //TODO complete
        //TODO if the line is of a wrong format then return it with the postfix '#wrong format' back. 'hello world'-> 'hello world#wrong format'
        //TODO or 'hello world#upper_case#param'-> 'hello world#upper_case#param#wrong format'

        //TODO Get the operation by its name.

        //TODO if the format seems to be correct, but the operation is not found then write to the file the line with the
        //TODO postfix '#wrong operation'. E.g. "hello world#opper_case" -> "hello world#opper_case#wrong operation"
    }
}
