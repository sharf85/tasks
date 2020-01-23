package com.telran.action;

import java.util.List;

public abstract class TextAction {

    private String inputFilename;
    private String outputFilename;

    public TextAction(String inputFilename, String outputFilename) {
        this.inputFilename = inputFilename;
        this.outputFilename = outputFilename;
    }

    public void perform() {
        List<String> content = readFromFile(inputFilename);
        //something happens
        performTask(content);
        writeToFile(content);
    }

    protected abstract void performTask(List<String> content);

    private void writeToFile(List<String> content) {

    }

    private List<String> readFromFile(String inputFilename) {
        return null;
    }

}
