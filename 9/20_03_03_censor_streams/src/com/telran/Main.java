package com.telran;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> badWords = Arrays.asList("Jean", "Klodt", "pam", "vam");

        String text = "Today I was at pam school , it was vam pam !";

        Censor censor = new Censor(badWords);
        System.out.println(censor.findBadWords(text));
    }
}
