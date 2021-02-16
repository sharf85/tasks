package de.telran.operation;

public class LowerCaseSO implements IStringOperation {
    @Override
    public String operate(String input) {
        return input.toLowerCase();
    }

    @Override
    public String getName() {
        return "lower_case";
    }
}
