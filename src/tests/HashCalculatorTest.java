package tests;

import main.HashCalculator;
import main.Hash;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import resources.PathResources;
import tools.FilesUtil;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

public class HashCalculatorTest {
    private HashCalculator hashCalculator;
    private Path testFile;

    // these values were calculated using an independent hash calculator
    private final String TEST_FILE_HASH_MD5 = "B746BB002EFBF7907CFF8548550F7C13";
    private final String TEST_FILE_HASH_SHA1 = "C4D0BB6C5B994BF6828E27047061E4C4A52D9A77";
    private final String TEST_FILE_HASH_SHA256 = "F6E6397E534DB699AD40210367EB6168E2FB426E9B7C3C65C4F1AABA57E20D98";
    private final String TEST_FILE_HASH_SHA512 = "2015F8704EF8392F834C8AA86419690F413B2DEA9B640A3C57D563AC44340679048E0DA89B3AB05EE749AAB70824ADB86902E13A70FEC9DCF7A6B9F59A9350D9";

    @BeforeEach
    private void setUp() {
        testFile = getTestFile();
    }

    @AfterEach
    private void tearDown() {
        hashCalculator = null;
        testFile = null;
    }

    private HashCalculator getCalculator(String algorithm) {
        return new HashCalculator(algorithm);
    }

    private Path getTestFile() {
        return FilesUtil.getFile(PathResources.EMPTY_TEST_FILE_PATH.getValue());
    }

    @Test
    void test_calculate_MD5() {
        hashCalculator = getCalculator(Hash.MD5.getAlgorithmName());
        String calculatedHash = hashCalculator.calculate(testFile);
        assertEquals(TEST_FILE_HASH_MD5, calculatedHash);
    }

    @Test
    void test_calculate_SHA1() {
        hashCalculator = getCalculator(Hash.SHA1.getAlgorithmName());
        String calculatedHash = hashCalculator.calculate(testFile);
        assertEquals(TEST_FILE_HASH_SHA1, calculatedHash);
    }

    @Test
    void test_calculate_SHA256() {
        hashCalculator = getCalculator(Hash.SHA256.getAlgorithmName());
        String calculatedHash = hashCalculator.calculate(testFile);
        assertEquals(TEST_FILE_HASH_SHA256, calculatedHash);
    }

    @Test
    void test_calculate_SHA512() {
        hashCalculator = getCalculator(Hash.SHA512.getAlgorithmName());
        String calculatedHash = hashCalculator.calculate(testFile);
        assertEquals(TEST_FILE_HASH_SHA512, calculatedHash);
    }
}