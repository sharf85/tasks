package com.telran.action;

import java.util.List;

public abstract class Action {

    protected String filename;
    protected String outputFilename;

    public Action(String filename, String outputFilename) {
        this.filename = filename;
        this.outputFilename = outputFilename;
    }

    public void performAction() {
        List<String> content = fileToList();
        perform(content);
        listToFile(content);
    }

    protected abstract void perform(List<String> content);

    private void listToFile(List<String> content) {

    }

    private List<String> fileToList() {
        return null;
    }

}
