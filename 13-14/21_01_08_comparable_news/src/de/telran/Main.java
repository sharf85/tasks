package de.telran;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<News> news = Arrays.asList(
                new News("Hello world", 9),
                new News("Trump is no more president", 5),
                new News("Bitcoin is greater than 30000$", 9)
        );

        Collections.sort(news);
        Arrays.sort(news.toArray());

        System.out.println(news);
    }
}
