package com.telran.calculator;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OperationManagerTest {

    OperationManager om;

    @Before
    public void init() {
        om = new OperationManager(new ArrayList<>());
        om.operationBySymbol = mock(Map.class);
    }

    @Test
    public void testGet() {
        Operation multiOperation = mock(Operation.class);
        when(om.operationBySymbol.get('*')).thenReturn(multiOperation);

        assertEquals(multiOperation, om.get('*'));
    }

}