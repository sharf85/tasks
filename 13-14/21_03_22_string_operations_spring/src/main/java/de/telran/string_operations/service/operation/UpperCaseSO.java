package de.telran.string_operations.service.operation;

import org.springframework.stereotype.Service;

@Service
public class UpperCaseSO implements IStringOperation {

    @Override
    public String operate(String input) {
        return input.toUpperCase();
    }

    @Override
    public String getName() {
        return "upper_case";
    }
}
