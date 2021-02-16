package de.telran;

import de.telran.operation.OperationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ExecutorService;

/**
 *
 */
public class Supplier implements Runnable {

    private final BufferedReader br;
    private final PrintWriter writer;
    private final ExecutorService executor;
    private final OperationContext operationContext;

    public Supplier(BufferedReader br, PrintWriter writer, ExecutorService executor, OperationContext operationContext) {
        this.br = br;
        this.writer = writer;
        this.executor = executor;
        this.operationContext = operationContext;
    }


    @Override
    public void run() {
        String line;
        try {
            while ((line = br.readLine()) != null) {
                Runnable task = new LineHandlerTask(line, writer, operationContext);
                executor.execute(task);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
