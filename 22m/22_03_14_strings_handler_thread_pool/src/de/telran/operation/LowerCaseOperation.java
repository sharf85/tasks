package de.telran.operation;

import de.telran.IStringOperation;

public class LowerCaseOperation implements IStringOperation {
    @Override
    public String operate(String line) {
        return line.toLowerCase();
    }

    @Override
    public String getName() {
        return "to_lower_case";
    }
}
