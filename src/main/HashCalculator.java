package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Calculates the hash of a given input, using a specified algorithm.
 * @author Bryan R Martinez
 * @since 03/2018
 */
public class HashCalculator {
    private MessageDigest messageDigest;

    public HashCalculator(String algorithmName) {
        try {
            messageDigest = MessageDigest.getInstance(algorithmName);

        } catch (NoSuchAlgorithmException e) {
            System.err.println(String.format("No algorithm named %s.", algorithmName));
            e.printStackTrace();
            System.exit(-1);
        }
    }

    /**
     * Calculates hash of a given file.
     * Note, this method ignores directories.
     *
     * @param file
     * @return uppercase hex string of given file
     */
    public String calculate(Path file) {
        String hash = "";

        if (!Files.isDirectory(file)) {
            // only calculate hash of files (i.e. not directories)
            try {
                byte[] bytes = Files.readAllBytes(file);
                hash = calculate(bytes);

            } catch (IOException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }

        return hash;
    }

    /**
     * Determines hash of given byte array.
     *
     * @param bytes
     * @return uppercase hex string of given bytes array
     */
    public String calculate(byte[] bytes) {
        byte[] digest = messageDigest.digest(bytes);
        return bytesToHex(digest);
    }

    /**
     * Used to eliminate dependency on javax.xml.bind.DatatypeConverter.
     * Originally implemented by github.com/jexler for grengine.
     *
     * @param bytes
     * @return uppercase hex string of given bytes array
     */
    private String bytesToHex(byte[] bytes) {
        StringBuilder builder = new StringBuilder(32);
        int digit;

        for (byte b : bytes) {
            digit = (b >> 4) & 0xF;
            builder.append(digit < 10 ? (char)('0' + digit) : (char)('A' - 10 + digit));
            digit = (b & 0xF);
            builder.append(digit < 10 ? (char)('0' + digit) : (char)('A' - 10 + digit));
        }

        return builder.toString();
    }
}
