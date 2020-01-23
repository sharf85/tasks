package com.telran.action;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Action {

    protected String filename;
    protected String outputFilename;

    public Action(String filename, String outputFilename) {
        this.filename = filename;
        this.outputFilename = outputFilename;
    }

    public void performAction() throws IOException {
        List<String> content = fileToList();
        perform(content);
        listToFile(content);
    }

    protected abstract void perform(List<String> content);

    private void listToFile(List<String> content) throws FileNotFoundException {
//        try (PrintWriter pw = new PrintWriter(outputFilename)) {
//            for (String line : content) {
//                pw.println(line);
//            }
//        }

//        old school
        PrintWriter pw = new PrintWriter(outputFilename);
        try {
            for (String line : content) {
                pw.println(line);
            }
        } finally {
            pw.close();
        }

    }

    private List<String> fileToList() throws IOException {
//        new style
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            List<String> res = new ArrayList<>();

            String line;
            while ((line = br.readLine()) != null) {
                res.add(line);
            }
            return res;
        }
    }

}
