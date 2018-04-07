package main.enums;

public enum HashAlgorithmType {
    MD5("MD5"),
    SHA1("SHA1"),
    SHA256("SHA-256"),
    SHA512("SHA-512");

    private String algorithmName;
    HashAlgorithmType(String algorithmName) { this.algorithmName = algorithmName; }
    public String getAlgorithmName() { return this.algorithmName; }
}
