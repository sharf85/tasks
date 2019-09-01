package com.telran.reverse_string;

public class StringReverser {

    public String reverse(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        return sb.toString();
    }
}
