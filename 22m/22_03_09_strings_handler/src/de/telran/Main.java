package de.telran;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, InterruptedException {
        // create a print writer, which is shared among all the consumers
        try (PrintWriter pw = new PrintWriter("output.txt");) {

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
            TextConsumer consumer3 = new TextConsumer(queue, operationContext, pw);

            consumer1.setNextConsumerThread(consumer2);
            consumer2.setNextConsumerThread(consumer3);
            consumer3.setNextConsumerThread(consumer1);

            consumer1.start();
            consumer2.start();
            consumer3.start();

            consumer1.join();
            consumer2.join();
            consumer3.join();
        }
    }

    private static List<String> getOperationPaths(String filename) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileReader(filename));
        String pathsString = properties.getProperty("paths");
        return Arrays.asList(pathsString.split(","));
    }
}
