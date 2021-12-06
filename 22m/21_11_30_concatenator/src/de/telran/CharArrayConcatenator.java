package de.telran;

public class CharArrayConcatenator implements IConcatenator {
    @Override
    public String concatenate(String[] strings) {
        int length = 0;

        for (int i = 0; i < strings.length; i++) {
            length += strings[i].length();
        }

        char[] chars = new char[length];
        int currentIndex = 0;

        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings[i].length(); j++) {
                chars[currentIndex] = strings[i].charAt(j);
                currentIndex++;
            }
        }

        return String.valueOf(chars);
    }
}
