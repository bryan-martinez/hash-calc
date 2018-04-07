package main.calculators;

import main.args.FileHashCalculatorArgs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileHashCalculator extends HashCalculator implements Runnable {
    private Path file;
    private String fileHash = "";

    public FileHashCalculator(FileHashCalculatorArgs args) {
        super(args.getHashAlgorithmType());
        this.file = args.getFile();
    }

    /**
     * Calculates hash of the specified file.
     */
    @Override
    public void run() {
        if (!Files.isDirectory(file)) {
            // only calculate hash of files
            try {
                byte[] bytes = Files.readAllBytes(file);
                this.fileHash = calculate(bytes);

            } catch (IOException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
    }

    public Path getFile() {
        return file;
    }

    public void setFile(Path file) {
        this.file = file;
    }

    public String getFileHash() {
        return fileHash;
    }

    public void setFileHash(String fileHash) {
        this.fileHash = fileHash;
    }
}
