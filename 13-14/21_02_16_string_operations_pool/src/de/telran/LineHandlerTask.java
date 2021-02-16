package de.telran;

import de.telran.operation.IStringOperation;
import de.telran.operation.OperationContext;

import java.io.PrintWriter;

public class LineHandlerTask implements Runnable {

    public static final String SEPARATOR = "#";
    public static final String WRONG_FORMAT = "wrong format";
    public static final String WRONG_OPERATION = "wrong operation";
    private final PrintWriter writer;
    private final OperationContext context;
    private final String line;

    public LineHandlerTask(String line, PrintWriter writer, OperationContext context) {
        this.writer = writer;
        this.context = context;
        this.line = line;
    }

    @Override
    public void run() {
        String res = handleRawString(line);
        writer.println(res);
    }

    String handleRawString(String line) {
        String[] result = line.split(SEPARATOR);

        if (result.length != 2)
            return line + SEPARATOR + WRONG_FORMAT;

        String stringToPerform = result[0];
        String operationName = result[1];

        IStringOperation stringOperation = context.getOperation(operationName);

        if (stringOperation == null)
            return line + SEPARATOR + WRONG_OPERATION;

        return stringOperation.operate(stringToPerform);
    }
}
