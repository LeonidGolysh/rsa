package org.example.generator;

import java.math.BigInteger;

public class KeysGenerator {
    public BigInteger[] generatePublicKey(int p, int q) {
        BigInteger n = BigInteger.valueOf(p).multiply(BigInteger.valueOf(q));
        BigInteger phi = BigInteger.valueOf(p - 1).multiply(BigInteger.valueOf(q - 1));
        BigInteger e = BigInteger.valueOf(65537);

        return new BigInteger[]{e, n};
    }

    public BigInteger[] generatePrivateKey(int p, int q) {
        BigInteger n = BigInteger.valueOf(p).multiply(BigInteger.valueOf(q));
        BigInteger m = BigInteger.valueOf(p - 1).multiply(BigInteger.valueOf(q - 1));
        BigInteger e = generatePublicKey(p, q)[0];
        BigInteger d = e.modInverse(m);

        return new BigInteger[]{d, n};
    }
}
