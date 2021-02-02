package de.telran;

import java.io.IOException;
import java.util.List;

public interface IPrinter {

    void writeToFile(String filename, List<String> text) throws IOException;
}
