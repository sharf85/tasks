package de.telran.action;

import de.telran.FileOperations;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class CapitalLettersFileActionTest {

    //    @Mock
    FileOperations fileOperations;

    //    @InjectMocks
    CapitalLettersFileAction capLet;

    @BeforeEach
    public void init() {
        fileOperations = mock(FileOperations.class);
        capLet = new CapitalLettersFileAction(fileOperations);
    }

    @Test
    public void test_perform_lowerCase() {
        ArrayList<String> exp = new ArrayList<>(Arrays.asList("APPLE", "BANANA", "APRICOT", "CHERRY"));
        assertEquals(exp, capLet.perform(Arrays.asList("apple", "banana", "apricot", "cherry")));
    }

    @Test
    public void test_perform_mixedCase() {
        ArrayList<String> exp = new ArrayList<>(Arrays.asList("APPLE", "BANANA", "APRICOT", "CHERRY"));
        assertEquals(exp, capLet.perform(Arrays.asList("aPPle", "Banana", "Apricot", "cheRRY")));
    }

}
