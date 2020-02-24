package com.telran.handler.operation;

import com.telran.handler.IOperation;

public class UpperCaseOperation implements IOperation {
    private static final String NAME = "uppercase";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String operate(String text) {
        return text.toUpperCase();
    }
}
