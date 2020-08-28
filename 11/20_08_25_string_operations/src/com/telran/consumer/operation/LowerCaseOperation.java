package com.telran.consumer.operation;

import com.telran.consumer.IStringOperation;

public class LowerCaseOperation implements IStringOperation {
    private static final String NAME = "lower_case";

    @Override
    public String operate(String line) {
        return line.toLowerCase();
    }

    @Override
    public String getName() {
        return NAME;
    }

}
