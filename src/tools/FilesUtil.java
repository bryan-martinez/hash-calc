package tools;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesUtil {
    public static Path createTempFile() {
        Path path = null;

        try {
            path = Files.createTempFile("temp_", "_file");

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        return path;
    }

    public static Path getFile(String filePath) {
        return Paths.get(filePath);
    }
}
