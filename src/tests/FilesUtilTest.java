package tests;

import org.junit.jupiter.api.Test;
import resources.PathResources;
import tools.FilesUtil;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class FilesUtilTest {
    @Test
    void test_createTempFile() {
        Path tempFile = FilesUtil.createTempFile();
        assertNotNull(tempFile);
    }

    @Test
    void test_getFile() {
        Path file = FilesUtil.getFile(PathResources.EMPTY_TEST_FILE_PATH.getValue());
        assertNotNull(file);
        assertEquals(PathResources.EMPTY_TEST_FILE_PATH.getValue(), file.toString());
    }
}