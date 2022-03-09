package de.telran.opertion;

import de.telran.IStringOperation;

public class UpperCaseOperation implements IStringOperation {
    @Override
    public String operate(String line) {
        return line.toUpperCase();
    }

    @Override
    public String getName() {
        return "to_upper_case";
    }
}
