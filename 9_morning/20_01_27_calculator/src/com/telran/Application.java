package com.telran;

import com.telran.calculator.CharCalculator;
import com.telran.calculator.ICalculator;
import com.telran.calculator.ModernCalculator;
import com.telran.calculator.OperationManager;
import com.telran.util.FileOperations;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

public class Application {

    private static final String INPUT_FILENAME = "input.txt";
    private static final String OUTPUT_FILENAME = "output.txt";

    /**
     * @param args args[0] input filename if present, args[1] output filename if present
     * @throws FileNotFoundException if output filename is not legal
     */
    public static void main(String[] args) throws IOException {
        List<String> content;

        String inputFilename = args.length > 0 ? args[0] : INPUT_FILENAME;
        String outputFilename = args.length > 1 ? args[1] : OUTPUT_FILENAME;

        FileOperations fo = new FileOperations();
        try {
            content = fo.fileToList(inputFilename);
        } catch (IOException e) {
            List<String> errorList = Collections.singletonList("No file " + inputFilename + " found");
            fo.listToFile(errorList, outputFilename);
            e.printStackTrace();
            return;
        }

        List<String> operationPaths = getPaths();

        OperationManager om = new OperationManager(operationPaths);
        ICalculator calculator = new ModernCalculator(om);
        OperationProcessor processor = new OperationProcessor(calculator);
        List<String> outputContent = processor.processStrings(content);

        fo.listToFile(outputContent, outputFilename);
    }

    public static List<String> getPaths() throws IOException {
        Properties props = new Properties();
        props.load(new FileReader("config/config.props"));
        String pack = props.getProperty("operations_package");
        String operations_string = props.getProperty("operations");
        String[] operations = operations_string.split(",");
        List<String> operationPaths = new ArrayList<>();
        for (String operation : operations) {
            operationPaths.add(pack + "." + operation);
        }
        return operationPaths;
    }
}
