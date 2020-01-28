package com.telran;

import com.telran.calculator.ICalculator;
import com.telran.calculator.SimpleCalculator;
import com.telran.util.FileOperations;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Application {

    private static final String INPUT_FILENAME = "fileInput.txt";
    private static final String OUTPUT_FILENAME = "output.txt";

    public static void main(String[] args) throws FileNotFoundException {
        FileOperations fo = new FileOperations();

        List<String> content;
        try {
            content = fo.fileToList(INPUT_FILENAME);
        } catch (IOException e) {
            List<String> errorList = Arrays.asList("No file " + INPUT_FILENAME + " found");
            fo.listToFile(errorList, OUTPUT_FILENAME);
            e.printStackTrace();
            return;
        }

        ICalculator calculator = new SimpleCalculator();
        OperationProcessor processor = new OperationProcessor(calculator);
        List<String> outputContent = processor.processStrings(content);

        fo.listToFile(outputContent, OUTPUT_FILENAME);
    }
}
