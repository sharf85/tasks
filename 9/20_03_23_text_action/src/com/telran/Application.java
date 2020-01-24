package com.telran;

import com.telran.action.*;

import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {

        TextAction reverseAction = new ReverseAction("WarPeace.txt", "reversed.txt");
        reverseAction.perform();

        TextAction sortAction = new SortAction("WarPeace.txt", "sort.txt");
        sortAction.perform();

        TextAction toUpperCaseAction = new ToUpperCaseAction("WarPeace.txt", "uppercase.txt");
        toUpperCaseAction.perform();

    }
}
