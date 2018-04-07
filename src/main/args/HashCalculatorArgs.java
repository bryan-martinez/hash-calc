package main.args;

import main.enums.HashAlgorithmType;

abstract class HashCalculatorArgs {
    private HashAlgorithmType hashAlgorithmType;

    public HashAlgorithmType getHashAlgorithmType() {
        return hashAlgorithmType;
    }

    public void setHashAlgorithmType(HashAlgorithmType hashAlgorithmType) {
        this.hashAlgorithmType = hashAlgorithmType;
    }
}
