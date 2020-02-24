package com.telran.handler.operation;

import com.telran.handler.IOperation;

public class ReverseOperation implements IOperation {
    private static final String NAME = "reverse";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String operate(String input) {
        return new StringBuilder(input).reverse().toString();
    }
}
