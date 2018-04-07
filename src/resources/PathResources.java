package resources;

import java.io.File;
import java.text.MessageFormat;

public enum PathResources {
    EMPTY_TEST_FILE_PATH(MessageFormat.format("src{0}data{0}EmptyTest.txt", File.separator));

    private String path;
    PathResources(String path) { this.path = path; }
    public String getPath() { return path; }
}
