package de.telran.concatenator;

import de.telran.IConcatenator;

public class StringBufferConcatenator implements IConcatenator {
    @Override
    public void concatenate(String[] arrayToConcatenate) {
        StringBuffer buffer = new StringBuffer();
        for (String str : arrayToConcatenate) {
            buffer.append(str);
        }
        buffer.toString();
    }
}
