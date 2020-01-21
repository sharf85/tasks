package com.telran.action;

import java.util.Collections;
import java.util.List;

public class ReverseAction extends Action {

    public ReverseAction(String filename, String outputFilename) {
        super(filename, outputFilename);
    }

    @Override
    protected void perform(List<String> content) {
        Collections.reverse(content);
    }
}
