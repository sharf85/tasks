package com.telran.consumer.operation;

import com.telran.consumer.IStringOperation;

public class ReverseOperation implements IStringOperation {

    private static final String NAME = "reverse";

    @Override
    public String operate(String line) {
        return new StringBuilder(line).reverse().toString();
    }

    @Override
    public String getName() {
        return NAME;
    }
}
