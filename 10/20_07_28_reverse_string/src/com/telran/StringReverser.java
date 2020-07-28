package com.telran;

public class StringReverser {
    public String reverse(String text) {
        StringBuilder builder = new StringBuilder(text);
        builder.reverse();
        return builder.toString();
    }
}
