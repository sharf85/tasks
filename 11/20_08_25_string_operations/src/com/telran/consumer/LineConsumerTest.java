package com.telran.consumer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.PrintWriter;
import java.util.concurrent.BlockingQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class LineConsumerTest {

    LineConsumer lineConsumer;

    BlockingQueue<String> lineQueue;
    PrintWriter pw;
    OperationStorage storage;

    @BeforeEach
    public void init() {
        lineQueue = mock(BlockingQueue.class);
        pw = mock(PrintWriter.class);
        storage = mock(OperationStorage.class);

        lineConsumer = new LineConsumer(lineQueue, storage, pw);
    }

    @Test
    public void testProcessLine_textWithoutOperation_wrongLine() {
        String toProcess = "hello";
        String expected = "hello" + LineConsumer.DELIMITER + LineConsumer.WRONG_LINE;
        assertEquals(expected, lineConsumer.processLine(toProcess));
    }

    @Test
    public void testProcessLine_threePartsInText_wrongLine() {
        String toProcess = "hello#some_operation#addition";

        IStringOperation someOperation = mock(IStringOperation.class);
        when(someOperation.operate("hello")).thenReturn("HellO");
        when(storage.getByName("some_operation")).thenReturn(someOperation);

        String expected = toProcess + LineConsumer.DELIMITER + LineConsumer.WRONG_LINE;
        assertEquals(expected, lineConsumer.processLine(toProcess));
    }

    @Test
    public void testProcessLine_textWithWrongOperation_wrongOperation() {
        String toProcess = "hello#some_operation";

        when(storage.getByName("some_operation")).thenReturn(null);

        String expected = toProcess + LineConsumer.DELIMITER + LineConsumer.WRONG_OPERATION;
        assertEquals(expected, lineConsumer.processLine(toProcess));
    }

    @Test
    public void testProcessLine_textWithRightOperation_transformedText() {
        String toProcess = "hello#some_operation";

        IStringOperation someOperation = mock(IStringOperation.class);
        when(someOperation.operate("hello")).thenReturn("HellO");

        when(storage.getByName("some_operation")).thenReturn(someOperation);

        String expected = "HellO";
        assertEquals(expected, lineConsumer.processLine(toProcess));
    }

}
