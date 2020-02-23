package com.telran.operation;

import com.telran.IOperation;

public class ReverseOperation implements IOperation {
    private static final String NAME = "reverse";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String operate(String input) {
        return null;
    }
}
