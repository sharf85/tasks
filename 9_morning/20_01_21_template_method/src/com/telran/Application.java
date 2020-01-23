package com.telran;

import com.telran.action.Action;
import com.telran.action.ReverseAction;
import com.telran.action.SortAction;
import com.telran.action.ToUpperCaseAction;

import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {
        Action reverse = new ReverseAction("WarPeace.txt", "reversed.txt");
        reverse.performAction();

        Action sort = new SortAction("WarPeace.txt", "sort.txt");
        sort.performAction();

        Action upperCase = new ToUpperCaseAction("WarPeace.txt", "upperCase.txt");
        upperCase.performAction();
    }
}
