package com.telran.operation;

import com.telran.IOperation;

public class UpperCaseOperation implements IOperation {

    private static final String NAME = "uppercase";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String operate(String input) {
        return null;
    }
}
