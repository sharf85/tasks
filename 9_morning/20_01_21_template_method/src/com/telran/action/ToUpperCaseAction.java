package com.telran.action;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class ToUpperCaseAction extends Action {

    public ToUpperCaseAction(String filename, String outputFilename) {
        super(filename, outputFilename);
    }

    @Override
    protected void perform(List<String> content) {
//        don't do this!!!
//        List<String> newContent = new ArrayList<>();
//
//        for (String line : content) {
//            newContent.add(line.toLowerCase());
//        }
//
//        content = newContent;

        List<String> temp = new ArrayList<>(content);
        content.clear();

        for (String line : temp) {
            content.add(line.toUpperCase());
        }

//        functional programming: the same
//        content.replaceAll(String::toUpperCase);
//        content.replaceAll(new ToUpperCaseOperator());
//        content.replaceAll(str -> str.toUpperCase());
    }
}

class ToUpperCaseOperator implements UnaryOperator<String> {

    @Override
    public String apply(String s) {
        return s.toUpperCase();
    }
}
