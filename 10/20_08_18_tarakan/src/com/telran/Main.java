package com.telran;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        List<Score> scores = new ArrayList<>();

        Tarakan[] tarakans = new Tarakan[10];
        for (int i = 0; i < tarakans.length; i++) {
            Tarakan tarakan = new Tarakan(10, String.valueOf(i), scores);
            tarakans[i] = tarakan;
        }

        for (Tarakan tarakan : tarakans) {
            tarakan.start();
        }

        for (Tarakan tarakan : tarakans) {
            tarakan.join();
        }

        int i = 0;
        for (Score score : scores) {
            String res = String.format("%d, The tarakan %s ran %d milliseconds"
                    , ++i, score.getName(), score.getResult());
            System.out.println(res);
        }
    }
}
