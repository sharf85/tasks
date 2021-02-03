package de.telran;

import java.util.List;

public abstract class FileAction {

    final FileOperations fileOperations;

    protected FileAction(FileOperations fileOperations) {
        this.fileOperations = fileOperations;
    }

    protected abstract List<String> perform(List<String> text);


    /**
     * The method receives a filename and must read the file into a {@link List} of Strings, calls the 'perform'
     * method, then writes the result back to the file.
     *
     * @param filename name of the file to handle
     */
    public void handleFile(String filename) {
//TODO implement here 3 string (exactly 3)
    }
}
