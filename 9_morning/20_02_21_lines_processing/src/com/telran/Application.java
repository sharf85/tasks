package com.telran;

import com.telran.handler.OperationProvider;
import com.telran.handler.TextHandler;
import com.telran.producer.TextProducer;
import com.telran.service.FileService;
import com.telran.service.PropertiesService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class Application {

    private static final String INPUT_FILENAME = "input.txt";
    private static final String OUTPUT_FILE = "output.txt";

    public static void main(String[] args) throws IOException, InterruptedException {
        PrintWriter pw = new PrintWriter(OUTPUT_FILE);
        BufferedReader br = new BufferedReader(new FileReader(INPUT_FILENAME));
        FileService fs = new FileService(pw, br);

        BlockingDeque<String> deque = new LinkedBlockingDeque<>();

        //load props
        PropertiesService ps = new PropertiesService("config/config.props");
        List<String> operationPaths = ps.getOperationPaths();
        //load operations by paths
        OperationProvider op = new OperationProvider(operationPaths);
        op.load();

        Thread[] producers = new Thread[2];
        for (int i = 0; i < producers.length; i++) {
            Thread th = new Thread(new TextProducer(fs, deque));
            producers[i] = th;
            th.start();
        }

        Thread[] handlers = new Thread[5];
        for (int i = 0; i < handlers.length; i++) {
            Thread th = new Thread(new TextHandler(op, deque, fs));
            handlers[i] = th;
            th.start();
        }

        for (Thread th : handlers) {
            th.join();
        }
        pw.close();
        br.close();
    }

}
