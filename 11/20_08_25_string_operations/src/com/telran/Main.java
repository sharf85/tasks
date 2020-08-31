package com.telran;

import com.telran.consumer.LineConsumer;
import com.telran.consumer.OperationStorage;
import com.telran.supplier.FileReadingThread;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

    private static final String OPERATION_PROPS_PATH = "config/operation.props";
    private static final String DEFAULT_INPUT_FILE = "input.txt";
    private static final String DEFAULT_OUTPUT_FILE = "output.txt";

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, InterruptedException {
        OperationProperties operationProperties = new OperationProperties(OPERATION_PROPS_PATH);
        operationProperties.load();

        List<String> operationPaths = operationProperties.getOperationPaths();

        OperationStorage operationStorage = new OperationStorage();
        operationStorage.init(operationPaths);

        PrintWriter pw = new PrintWriter(new FileOutputStream(DEFAULT_OUTPUT_FILE));
        BufferedReader br = new BufferedReader(new FileReader(DEFAULT_INPUT_FILE));

        BlockingQueue<String> lineQueue = new LinkedBlockingQueue<>();

        LineConsumer[] consumers = new LineConsumer[3];
        for (int i = 0; i < consumers.length; i++) {
            consumers[i] = new LineConsumer(lineQueue, operationStorage, pw);
            consumers[i].start();
        }

        FileReadingThread[] suppliers = new FileReadingThread[3];
        for (int i = 0; i < suppliers.length; i++) {
            suppliers[i] = new FileReadingThread(lineQueue, br);
            suppliers[i].start();
        }

        join(suppliers);
        endAllConsumers(consumers, lineQueue);

        join(consumers);
        br.close();
        pw.close();
    }

    private static void endAllConsumers(LineConsumer[] consumers,
                                        BlockingQueue<String> lineQueue) {
        for (int i = 0; i < consumers.length; i++) {
            lineQueue.add(LineConsumer.STOP_COMMAND);
        }
    }

    private static void join(Thread[] threads) throws InterruptedException {
        for (Thread th : threads) {
            th.join();
        }
    }
}
