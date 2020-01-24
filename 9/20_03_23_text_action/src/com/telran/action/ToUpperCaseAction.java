package com.telran.action;

import java.util.List;

public class ToUpperCaseAction extends TextAction {
    public ToUpperCaseAction(String inputFilename, String outputFilename) {
        super(inputFilename, outputFilename);
    }

    @Override
    protected void performTask(List<String> content) {
//        int size = content.size();
//        for (int i = 0; i < size; i++) {
//            String line = content.get(i).toUpperCase();
//            content.set(i, line);
//        }

//        List<String> temp = new ArrayList<>(content);
//        content.clear();
//
//        for (String line : temp) {
//            content.add(line.toUpperCase());
//        }

//        functional programming in action
        content.replaceAll(String::toUpperCase);
    }
}
