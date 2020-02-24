package com.telran;

import com.telran.handler.IOperation;
import com.telran.handler.OperationProvider;
import com.telran.handler.TextHandler;
import com.telran.handler.operation.LowerCaseOperation;
import com.telran.handler.operation.UpperCaseOperation;
import com.telran.service.FileService;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Application {

    private static final String DELIMITER = "#";
    private static final String INPUT_FILE = "input.txt";
    private static final String OUTPUT_FILE = "output.txt";

    public static void main(String[] args) throws IOException, InterruptedException {
        PrintWriter pw = new PrintWriter(OUTPUT_FILE);
        FileService fs = new FileService(pw);

        List<String> operationPath = getOperationPaths();
        OperationProvider op = new OperationProvider();
        op.init(operationPath);

        Deque<String> deque = new ConcurrentLinkedDeque<>();
        fs.readFileToCollection(INPUT_FILE, deque);

        Thread[] handlers = new Thread[5];
        for (int i = 0; i < handlers.length; i++) {
            Thread th = new TextHandler(op, deque, DELIMITER, fs);
            handlers[i] = th;
            th.start();
        }

        for (Thread handler : handlers) {
            handler.join();
        }

        pw.close();
    }


    public static List<String> getOperationPaths() throws IOException {
        Properties props = new Properties();
        props.load(new FileReader("config/config.props"));

        String pack = props.getProperty("operations_package");
        String operations_string = props.getProperty("operations");
        String[] operations = operations_string.split(",");
        List<String> operationPaths = new ArrayList<>();
        for (String operation : operations) {
            operationPaths.add(pack + "." + operation);
        }
        return operationPaths;
    }
}
