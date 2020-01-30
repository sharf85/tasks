package com.telran;

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

        String inputFilename = args.length > 0 ? args[0] : INPUT_FILENAME;
        String outputFilename = args.length > 1 ? args[1] : OUTPUT_FILENAME;

        FileOperations fo = new FileOperations();

        List<String> content;
        try {
            content = fo.fileToList(inputFilename);
        } catch (IOException e) {
            List<String> error = Arrays.asList("File not found: " + inputFilename);
            fo.listToFile(error, outputFilename);
            return;
        }

        ICalculator calculator = new CharCalculator();
        LineProcessor processor = new LineProcessor(calculator);
        List<String> output = processor.processLines(content);
        fo.listToFile(output, outputFilename);

    }
}
