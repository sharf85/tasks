package com.telran;

import com.telran.calculator.BadCalculator;
import com.telran.calculator.CharCalculator;
import com.telran.calculator.ICalculator;
import com.telran.calculator.LineProcessor;
import com.telran.util.FileOperations;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Application {

    public static final String INPUT_FILENAME = "input.txt";
    public static final String OUTPUT_FILENAME = "output.txt";

    public static void main(String[] args) throws FileNotFoundException {
        FileOperations fo = new FileOperations();

        List<String> content;
        try {
            content = fo.fileToList(INPUT_FILENAME);
        } catch (IOException e) {
            List<String> error = Arrays.asList("File not found: " + INPUT_FILENAME);
            fo.listToFile(error, OUTPUT_FILENAME);
            return;
        }

//        ICalculator calculator = new BadCalculator();
        ICalculator calculator = new CharCalculator();
        LineProcessor processor = new LineProcessor(calculator);
        List<String> output = processor.processLines(content);
        fo.listToFile(output, OUTPUT_FILENAME);

    }
}
