package com.telran.action;

import java.util.Collections;
import java.util.List;

public class SortAction extends TextAction {
    public SortAction(String inputFilename, String outputFilename) {
        super(inputFilename, outputFilename);
    }

    @Override
    protected void performTask(List<String> content) {
        Collections.sort(content);
    }
}
