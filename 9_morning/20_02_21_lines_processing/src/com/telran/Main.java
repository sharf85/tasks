package com.telran;

import com.telran.operation.LowerCaseOperation;
import com.telran.operation.UpperCaseOperation;

import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Main {

    public static void main(String[] args) {
        Deque<String> deque = new ConcurrentLinkedDeque<>();
        //TODO read file into deque via BufferedReader

        Map<String, IOperation> operationByName = new HashMap<>();
        operationByName.put("lowercase", new LowerCaseOperation());
        operationByName.put("uppercase", new UpperCaseOperation());
        //TODO remake this using config.props file, as it's done in the Calculator project

        OperationProvider op = new OperationProvider(operationByName);

        Thread[] handlers = new Thread[5];
        for (int i = 0; i < handlers.length; i++) {
            Thread th = new Thread(new TextHandler(op, deque));
            handlers[i] = th;
            th.start();
        }
    }
}
