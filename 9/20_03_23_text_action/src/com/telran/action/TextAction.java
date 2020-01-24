package com.telran.action;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class TextAction {

    private String inputFilename;
    private String outputFilename;

    public TextAction(String inputFilename, String outputFilename) {
        this.inputFilename = inputFilename;
        this.outputFilename = outputFilename;
    }

    public void perform() throws IOException {
        List<String> content = readFromFile(inputFilename);
        //something happens
        performTask(content);
        writeToFile(content);
    }

    protected abstract void performTask(List<String> content);

    private void writeToFile(List<String> content) throws FileNotFoundException {

        try (PrintWriter pw = new PrintWriter(outputFilename)) {
            for (String line : content) {
                pw.println(line);
            }
        }
    }

    private List<String> readFromFile(String inputFilename) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFilename))) {
            List<String> res = new ArrayList<>();

            String line;
            while ((line = br.readLine()) != null) {
                res.add(line);
            }

            return res;
        }
    }

}
