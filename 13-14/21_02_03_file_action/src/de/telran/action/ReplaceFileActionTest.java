package de.telran.action;

import de.telran.FileOperations;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class ReplaceFileActionTest {

    FileOperations fileOperations;

    ReplaceFileAction replace;

    @BeforeEach
    public void init() {
        fileOperations = mock(FileOperations.class);
        replace = new ReplaceFileAction(fileOperations, " ", "*");
    }

    @Test
    public void test_perform() {
        ArrayList<String> exp = new ArrayList<>(Arrays.asList("212*8506", "xx*x", "40*4", "1*12"));
        assertEquals(exp, replace.perform(Arrays.asList("212 8506", "xx x", "40 4", "1 12")));
    }

}
