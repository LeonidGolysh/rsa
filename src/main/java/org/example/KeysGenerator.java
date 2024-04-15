package org.example;

import java.math.BigInteger;

public class KeysGenerator {
    public BigInteger[] generatePublicKey(int p, int q) {
        BigInteger n = BigInteger.valueOf(p).multiply(BigInteger.valueOf(q));
        BigInteger phi = BigInteger.valueOf(p - 1).multiply(BigInteger.valueOf(q - 1));
        BigInteger e;

        do {
            e = BigInteger.valueOf((int) (Math.random() * (phi.intValue() - 2) + 2));
        } while (!e.gcd(phi).equals(BigInteger.ONE));

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
