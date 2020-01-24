package com.telran.action;

import java.util.Collections;
import java.util.List;

public class ReverseAction extends TextAction {
    public ReverseAction(String inputFilename, String outputFilename) {
        super(inputFilename, outputFilename);
    }

    @Override
    protected void performTask(List<String> content) {
        Collections.reverse(content);
    }
}
