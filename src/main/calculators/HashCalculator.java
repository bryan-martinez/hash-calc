package main.calculators;

import main.enums.HashAlgorithmType;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Calculates the hash of a given byte array, using a specified algorithm.
 *
 * @author Bryan R Martinez
 */
abstract class HashCalculator {
    private MessageDigest messageDigest;
    private HashAlgorithmType hashAlgorithmType;

    HashCalculator(HashAlgorithmType hashAlgorithmType) {
        this.hashAlgorithmType = hashAlgorithmType;

        try {
            this.messageDigest = MessageDigest.getInstance(hashAlgorithmType.getAlgorithmName());

        } catch (NoSuchAlgorithmException e) {
            System.err.println(String.format("No algorithm named %s.", hashAlgorithmType.getAlgorithmName()));
            e.printStackTrace();
            System.exit(-1);
        }
    }

    /**
     * Determines hash of given byte array.
     *
     * @param bytes
     * @return uppercase hex string of given bytes array
     */
    String calculate(byte[] bytes) {
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

    public HashAlgorithmType getHashAlgorithmType() {
        return hashAlgorithmType;
    }
}
