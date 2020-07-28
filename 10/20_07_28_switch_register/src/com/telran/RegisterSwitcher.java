package com.telran;

public class RegisterSwitcher {

    public String swap(String text) {
        char[] textChars = text.toCharArray();
        for (int i = 0; i < textChars.length; i++) {
            if (Character.isUpperCase(textChars[i])) {
                textChars[i] = Character.toLowerCase(textChars[i]);
            } else if (Character.isLowerCase(textChars[i])) {
                textChars[i] = Character.toUpperCase(textChars[i]);
            }
        }

        return new String(textChars);
    }
}
