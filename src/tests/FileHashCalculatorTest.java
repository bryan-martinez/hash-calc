package tests;

import main.args.FileHashCalculatorArgs;
import main.calculators.FileHashCalculator;
import main.enums.HashAlgorithmType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import resources.PathResources;
import tools.FilesUtil;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class FileFileHashCalculatorTest {
    private FileHashCalculator fileHashCalculator;
    private FileHashCalculatorArgs args;

    // these values were calculated using an independent hash calculator
    private final String TEST_FILE_HASH_MD5 = "B746BB002EFBF7907CFF8548550F7C13";
    private final String TEST_FILE_HASH_SHA1 = "C4D0BB6C5B994BF6828E27047061E4C4A52D9A77";
    private final String TEST_FILE_HASH_SHA256 = "F6E6397E534DB699AD40210367EB6168E2FB426E9B7C3C65C4F1AABA57E20D98";
    private final String TEST_FILE_HASH_SHA512 = "2015F8704EF8392F834C8AA86419690F413B2DEA9B640A3C57D563AC44340679048E0DA89B3AB05EE749AAB70824ADB86902E13A70FEC9DCF7A6B9F59A9350D9";

    @AfterEach
    private void tearDown() {
        fileHashCalculator = null;
        args = null;
    }

    private Path getTestFile() {
        return FilesUtil.getFile(PathResources.EMPTY_TEST_FILE_PATH.getValue());
    }

    private FileHashCalculatorArgs getArgs(HashAlgorithmType hashAlgorithmType) {
        args = new FileHashCalculatorArgs();
        args.setHashAlgorithmType(hashAlgorithmType);
        args.setFile(getTestFile());
        return args;
    }

    private String calculate(HashAlgorithmType hashAlgorithmType) {
        FileHashCalculator calc = new FileHashCalculator(getArgs(hashAlgorithmType));
        calc.run();
        return calc.getFileHash();
    }

    @Test
    void test_calculate_MD5() {
        String calculatedHash = calculate(HashAlgorithmType.MD5);
        assertEquals(TEST_FILE_HASH_MD5, calculatedHash);
    }

    @Test
    void test_calculate_SHA1() {
        String calculatedHash = calculate(HashAlgorithmType.SHA1);
        assertEquals(TEST_FILE_HASH_SHA1, calculatedHash);
    }

    @Test
    void test_calculate_SHA256() {
        String calculatedHash = calculate(HashAlgorithmType.SHA256);
        assertEquals(TEST_FILE_HASH_SHA256, calculatedHash);
    }

    @Test
    void test_calculate_SHA512() {
        String calculatedHash = calculate(HashAlgorithmType.SHA512);
        assertEquals(TEST_FILE_HASH_SHA512, calculatedHash);
    }
}