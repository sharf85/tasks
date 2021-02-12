package de.telran;

import de.telran.operation.OperationContext;

import java.io.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

    private static final String INPUT = "input.txt";
    private static final String OUTPUT = "output.txt";

    public static void main(String[] args) throws IOException, InterruptedException {

        //TODO read the props file and retrieve the operation paths from it. Then create an instance of the PerationContext
        //TODO using these paths.
        OperationContext operationContext = new OperationContext();

        BufferedReader br = new BufferedReader(new FileReader(INPUT));
        PrintWriter writer = new PrintWriter(new FileOutputStream(OUTPUT));
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();

        Thread consumerThread1 = new Thread(new Consumer(queue, writer, operationContext));
        Thread consumerThread2 = new Thread(new Consumer(queue, writer, operationContext));
        Thread consumerThread3 = new Thread(new Consumer(queue, writer, operationContext));
        Thread supplierThread = new Thread(new Supplier(br, queue));

//        consumerThread1.setDaemon(true);
//        consumerThread2.setDaemon(true);
//        consumerThread3.setDaemon(true);

        supplierThread.start();

        consumerThread1.start();
        consumerThread2.start();
        consumerThread3.start();

        supplierThread.join();

        //TODO come up with ending the consumer threads on time.

        writer.close();
        br.close();
    }
}
