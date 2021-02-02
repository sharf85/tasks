package de.telran;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class PrintWriterPrinter implements IPrinter {
    @Override
    public void writeToFile(String filename, List<String> text) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(filename))) {
            for (String line : text) {
                pw.println(line);
            }
        }
//        try {
//            for (String line : text) {
//                pw.println(line);
//            }
//        } finally {
//            pw.close();
//        }
    }
}
