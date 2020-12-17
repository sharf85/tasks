package de.telran.concatenator;

import de.telran.IConcatenator;

public class StringBuilderConcatenator implements IConcatenator {
    @Override
    public void concatenate(String[] arrayToConcatenate) {
        StringBuilder builder = new StringBuilder();
        for (String str : arrayToConcatenate) {
            builder.append(str);
        }
        builder.toString();
    }
}
