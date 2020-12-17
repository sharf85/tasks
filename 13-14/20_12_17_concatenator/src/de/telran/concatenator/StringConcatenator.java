package de.telran.concatenator;

import de.telran.IConcatenator;

public class StringConcatenator implements IConcatenator {
    @Override
    public void concatenate(String[] arrayToConcatenate) {
        String res = "";
        for (String str : arrayToConcatenate) {
            res += str;
        }
    }
}
