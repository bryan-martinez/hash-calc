package main.args;

import java.nio.file.Path;

public class FileHashCalculatorArgs extends HashCalculatorArgs {
    private Path file;

    public Path getFile() {
        return file;
    }

    public void setFile(Path file) {
        this.file = file;
    }
}
