package de.telran;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        // create a print writer, which is shared among all the consumers
        try (PrintWriter pw = new PrintWriter("output.txt")) {

            // load operations
            List<String> operationPaths = getOperationPaths("program.props");
            OperationContext operationContext = new OperationContext();
            operationContext.loadOperations(operationPaths);

            // create blocking queue
            BlockingQueue<String> queue = new LinkedBlockingQueue<>();

            // create and start supplier
            TextSupplier textSupplier = new TextSupplier("input.txt", queue);
            new Thread(textSupplier).start();

            // create and start several consumers
            TextConsumer consumer1 = new TextConsumer(queue, operationContext, pw);
            TextConsumer consumer2 = new TextConsumer(queue, operationContext, pw);

            new Thread(consumer1).start();
            new Thread(consumer2).start();
        }

    }

    private static List<String> getOperationPaths(String filename) {
        //TODO implement. Load paths from the props file
        // 1. read the property called "paths" as a string
        // 2. split it by "," and then apply Arrays.asList to obtain a list
        return null;
    }
}
