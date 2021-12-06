package de.telran;

public class StringBuilderConcatenator implements IConcatenator {
    @Override
    public String concatenate(String[] strings) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < strings.length; i++) {
            sb.append(strings[i]);
        }

        return sb.toString();
    }
}
