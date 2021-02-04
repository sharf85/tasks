package de.telran;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class FileActionTest {

    FileOperations fileOperations;

    FileAction capLet;

    @BeforeEach
    public void init() {
        fileOperations = mock(FileOperations.class);
        capLet = new FileAction(fileOperations) {
            @Override
            protected List<String> perform(List<String> text) {
                return null;
            }
        };
        capLet = spy(capLet);
    }


    @Test
    public void test_handle() throws IOException {
        when(fileOperations.readToList("filename")).thenReturn(Arrays.asList("Hello world", "guys!"));
        when(capLet.perform(Arrays.asList("Hello world", "guys!"))).thenReturn(Arrays.asList("world elloh", "!guys"));

        capLet.handleFile("filename");

        verify(fileOperations, times(1))
                .writeList(Arrays.asList("world elloh", "!guys"), "filename");
    }

}
