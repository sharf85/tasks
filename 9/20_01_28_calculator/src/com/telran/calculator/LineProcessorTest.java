package com.telran.calculator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LineProcessorTest {
    LineProcessor lp;
    ICalculator calculator;

    @Before
    public void init() {
        calculator = mock(ICalculator.class);
        lp = new LineProcessor(calculator);
    }

    @Test
    public void testProcessLine_legalOperationLegalFormat_result() throws OperationNotSupportedException {
        String inputString = "2.3,+,3.45";
        when(calculator.calculate(2.3, 3.45, '+')).thenReturn(5.75);
        assertEquals(inputString + ",5.75", lp.processLine(inputString));
    }
    
}