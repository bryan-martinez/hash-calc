package main;

public enum Hash {
    MD5("MD5"),
    SHA1("SHA1"),
    SHA256("SHA-256"),
    SHA512("SHA-512");

    private String algorithmName;
    Hash(String algorithmName) { this.algorithmName = algorithmName; }
    public String getAlgorithmName() { return this.algorithmName; }
}
