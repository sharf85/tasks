package com.telran.consumer;

import com.telran.consumer.operation.LowerCaseOperation;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class OperationStorageTest {
    OperationStorage storage = new OperationStorage();

    @Test
    public void testInit_oneExistingOperation_filledStorage() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        storage.init(Collections.singletonList("com.telran.consumer.operation.LowerCaseOperation"));
        assertEquals(1, storage.operationByName.size());

        IStringOperation operation = storage.operationByName.get("lower_case");
        assertTrue(operation instanceof LowerCaseOperation);
    }
}
