package de.telran;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileOperationsTest {
    FileOperations fileOperations = new FileOperations();

    @Test
    public void testWriteReadStrings() throws IOException {
        List<String> strings = Arrays.asList("Hello", "world", "friends");
        fileOperations.writeStrings(strings, "strings.txt");

        List<String> readStrings = fileOperations.readStrings("strings.txt");
        assertEquals(strings, readStrings);
    }

    @Test
    public void testWriteReadInts() throws IOException {
        List<Integer> ints = Arrays.asList(120, 239, 353);
        fileOperations.writeInts(ints, "integers.txt");

        List<Integer> readInts = fileOperations.readInts("integers.txt");
        assertEquals(ints, readInts);
    }
}
