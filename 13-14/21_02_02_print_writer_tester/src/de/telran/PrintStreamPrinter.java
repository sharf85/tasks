package de.telran;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

public class PrintStreamPrinter implements IPrinter {
    @Override
    public void writeToFile(String filename, List<String> text) throws IOException {
        try (PrintStream ps = new PrintStream(new FileOutputStream(filename))) {
            for (String line : text) {
                ps.println(line);
            }
        }
    }
}
