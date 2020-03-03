package com.telran;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String text = "I was at pAm vaM school . It was Vam pAm";

        Collection<String> badWords = Arrays.asList("jean", "claude", "vam", "pam");
        Censor censor = new Censor(badWords);

        List<String> foundWords = censor.findBadWords(text);
        System.out.println(foundWords);
    }
}
