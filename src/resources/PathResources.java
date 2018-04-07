package resources;

import java.io.File;
import java.text.MessageFormat;

public enum PathResources {
    EMPTY_TEST_FILE_PATH(MessageFormat.format("src{0}data{0}EmptyTest.txt", File.separator));

    private String value;
    PathResources(String value) { this.value = value; }
    public String getValue() { return value; }
}
