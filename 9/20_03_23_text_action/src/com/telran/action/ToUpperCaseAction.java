package com.telran.action;

import java.util.List;

public class ToUpperCaseAction extends TextAction {
    public ToUpperCaseAction(String inputFilename, String outputFilename) {
        super(inputFilename, outputFilename);
    }

    @Override
    protected void performTask(List<String> content) {
        String tmp;
        for (int i = 0; i < content.size(); i++) {
            tmp = content.get(i).toUpperCase();
            content.set(i, tmp);
        }
    }
}
