package de.telran;

import java.io.PrintWriter;
import java.util.concurrent.BlockingQueue;

public class TextTask implements Runnable {

    private final OperationContext operationContext;
    private final PrintWriter pw;
    private final String line;

    public TextTask(String line, OperationContext operationContext, PrintWriter pw) {
        this.line = line;
        this.operationContext = operationContext;
        this.pw = pw;
    }

    @Override
    public void run() {
        String res = handleLine(line);
        pw.println(res);
    }

    private String handleLine(String line) {

        String[] parts = line.split("#");
        if (parts.length != 2) {
            return line + "#" + "wrong format";
        }

        String operationName = parts[0];
        String text = parts[1];

        IStringOperation operation = operationContext.getOperation(operationName);

        if (operation == null)
            return line + "#" + "operation not supported";

        return operation.operate(text);
    }
}
