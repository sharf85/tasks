package de.telran;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, InterruptedException {
        // create a print writer, which is shared among all the consumers
        try (PrintWriter pw = new PrintWriter("output.txt");) {

            // load operations
            List<String> operationPaths = getOperationPaths("program.props");
            OperationContext operationContext = new OperationContext();
            operationContext.loadOperations(operationPaths);

            // create and start several consumers
            ExecutorService executorService = Executors.newFixedThreadPool(3);

            try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    executorService.execute(new TextTask(line, operationContext, pw));
                }
            }

            executorService.shutdown();
            executorService.awaitTermination(800, TimeUnit.MILLISECONDS);
        }
    }

    private static List<String> getOperationPaths(String filename) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileReader(filename));
        String pathsString = properties.getProperty("paths");
        return Arrays.asList(pathsString.split(","));
    }
}
