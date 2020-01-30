package com.telran;

import com.telran.calculator.ICalculator;
import com.telran.calculator.WrongOperandException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OperationProcessorTest {

    ICalculator calculator;
    OperationProcessor op;

    @Before
    public void init() {
        calculator = mock(ICalculator.class);
        op = new OperationProcessor(calculator);
    }

    @Test
    public void testProcessString_legalLine_returnsMultiplication() throws WrongOperandException {
        String line = "2.5,*,2";
        when(calculator.calculate(2.5, 2, '*')).thenReturn(5.);

        String expected = line + ",5.0";
        assertEquals(expected, op.processString(line));
    }

    @Test
    public void testProcessString_legalLineWrongOperation_throwsWrongOperandException() throws WrongOperandException {
        String line = "2.5,*,2";
        when(calculator.calculate(2.5, 2, '*')).thenThrow(WrongOperandException.class);

        String expected = line + OperationProcessor.DELIMITER + OperationProcessor.WRONG_OPERATION_ERROR_MESSAGE;
        assertEquals(expected, op.processString(line));
    }

}