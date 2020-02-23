package com.telran;

import com.telran.operation.LowerCaseOperation;
import com.telran.operation.UpperCaseOperation;

import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Main {

    //TODO leave a possibility to specify the delimiter via params
    private static final String DELIMITER = "#";

    public static void main(String[] args) {
        IOperation uppercase = new UpperCaseOperation();
        IOperation lowercase = new LowerCaseOperation();
        Map<String, IOperation> operationByName = new HashMap<>();
        //TODO fill operationByName via put method

        OperationProvider op = new OperationProvider(operationByName);
        Deque<String> deque = new ConcurrentLinkedDeque<>();
        //TODO read the input file into the deque

        for (int i = 0; i < 5; i++) {
            Thread th = new TextHandler(op, deque, DELIMITER);
            th.start();
        }
    }
}
