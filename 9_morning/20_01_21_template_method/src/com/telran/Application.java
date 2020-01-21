package com.telran;

import com.telran.action.Action;
import com.telran.action.ReverseAction;

public class Application {

    public static void main(String[] args) {
        Action reverse = new ReverseAction("file.txt");
        reverse.performAction();
    }
}
