package com.telran.handler.operation;

import com.telran.handler.IOperation;

public class LowerCaseOperation implements IOperation {
    private static final String NAME = "lowercase";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String operate(String input) {
        return input.toLowerCase();
    }
}
