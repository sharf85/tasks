package de.telran;

import de.telran.operation.OperationContext;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

    private static final String INPUT = "input.txt";
    private static final String OUTPUT = "output.txt";

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {

        ConfigReader configReader = new ConfigReader("config.props");
        List<String> operationPaths = configReader.getOperationPaths();
        OperationContext operationContext = new OperationContext(operationPaths);

        BufferedReader br = new BufferedReader(new FileReader(INPUT));
        PrintWriter writer = new PrintWriter(new FileOutputStream(OUTPUT));
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();

        Thread consumerThread1 = new Thread(new Consumer(queue, writer, operationContext));
        Thread consumerThread2 = new Thread(new Consumer(queue, writer, operationContext));
        Thread consumerThread3 = new Thread(new Consumer(queue, writer, operationContext));
        Thread supplierThread = new Thread(new Supplier(br, queue));

        supplierThread.start();

        consumerThread1.start();
        consumerThread2.start();
        consumerThread3.start();

        //wait until supplier completes
        supplierThread.join();

        // signal to the consumers that no new elements will appear in the queue
        consumerThread1.interrupt();
        consumerThread2.interrupt();
        consumerThread3.interrupt();

        // wait for consumers until they are done with the rest elements
        consumerThread1.join();
        consumerThread2.join();
        consumerThread3.join();

        writer.close();
        br.close();
    }
}
