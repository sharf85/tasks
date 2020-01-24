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

    private void writeToFile(List<String> content) throws IOException{
        try (FileWriter fw = new FileWriter(outputFilename)) {
            for (int i = 0; i < content.size(); i++) {
                fw.write(content.get(i) + "\n");
            }
        }
    }

    private List<String> readFromFile(String inputFilename) throws IOException{
        List<String> res = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(inputFilename))) {
            String line;
            while ((line = br.readLine()) != null) {
                res.add(line);
            }
        }
        return res;
    }

}
