package com.telran.consumer.operation;

import com.telran.consumer.IStringOperation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LowerCaseOperationTest {

    IStringOperation operation = new LowerCaseOperation();

    @Test
    public void testOperate_emptyString_emptyString() {
        assertEquals("", operation.operate(""));
    }

    @Test
    public void testOperate_upperCaseString_lowerCase() {
        assertEquals("abc", operation.operate("ABC"));
    }

    @Test
    public void testOperate_mixedStringWithSymbols_lowerCase() {
        assertEquals("asd*sd#;d", operation.operate("aSd*sD#;D"));
    }
}
