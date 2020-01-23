package com.telran;

import com.telran.action.*;

public class Application {

    public static void main(String[] args) {

        TextAction reverseAction = new ReverseAction("file.txt", "reversed.txt");
        reverseAction.perform();
    }
}
