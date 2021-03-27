package de.telran.string_operations.service;

import de.telran.string_operations.OperationContext;
import de.telran.string_operations.service.operation.IStringOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.PrintWriter;

@Service
public class StringHandler {

    private final OperationContext context;
    private final PrintWriter writer;
    private final String separator;
    private final String wrongOperation;
    private final String wrongFormat;

    // TODO take constants from the application props file. Other configure in the AppConfiguration
    public StringHandler(OperationContext context,
                         PrintWriter writer,
                         @Value("${de.telran.string_operation.handler.separator}")
                         String separator,
                         @Value("${de.telran.string_operation.handler.wrong_operation}")
                         String wrongOperation,
                         @Value("${de.telran.string_operation.handler.wrong_format}")
                         String wrongFormat) {
        this.context = context;
        this.writer = writer;
        this.separator = separator;
        this.wrongOperation = wrongOperation;
        this.wrongFormat = wrongFormat;
    }

    @Async
    public void handleString(String line) {
        String res = handleRawString(line);
        writer.println(res);
    }

    String handleRawString(String line) {
        String[] result = line.split(separator);

        if (result.length != 2)
            return line + separator + wrongFormat;

        String stringToPerform = result[0];
        String operationName = result[1];

        IStringOperation stringOperation = context.getOperation(operationName);

        if (stringOperation == null)
            return line + separator + wrongFormat;

        return stringOperation.operate(stringToPerform);

    }
}
