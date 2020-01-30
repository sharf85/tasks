package com.telran.calculator;

import org.junit.Test;

import static org.junit.Assert.*;

public class CharCalculatorTest {

    private CharCalculator charCalculator = new CharCalculator();

    @Test
    public void getClassName() {
        assertEquals("Operation_43", charCalculator.getClassName('+'));
    }
}