package com.telran.action;

import java.util.Collections;
import java.util.List;

public class ReverseAction extends Action {
    public ReverseAction(String filename) {
        super(filename);
    }

    @Override
    protected void perform(List<String> content) {
        Collections.reverse(content);
    }
}
