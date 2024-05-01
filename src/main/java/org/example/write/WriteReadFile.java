package org.example.write;

import org.example.crypt.Crypt;
import org.example.generator.KeysGenerator;
import org.example.generator.PrimePairGenerator;

import java.math.BigInteger;

public class WriteReadFile {
    private static final KeysGenerator keysGenerator = new KeysGenerator();
    private static final Crypt crypt = new Crypt();
    private static final PrimePairGenerator primePairGenerator = new PrimePairGenerator();

    public void start() {
        long startTime = System.currentTimeMillis();

        int min = 50;
        int max = 100;

        int[] primePair = primePairGenerator.generatePrimePair(min, max);

        BigInteger[] publicKey = keysGenerator.generatePublicKey(primePair[0], primePair[1]);
        BigInteger[] privateKey = keysGenerator.generatePrivateKey(primePair[0], primePair[1]);

        String inputFile = "src/main/resources/textForEncrypt.txt";
        String encryptedFileName = "src/main/resources/encrypted.txt";
        String decryptedFileName = "src/main/resources/decrypted.txt";

        crypt.encryptFile(inputFile, encryptedFileName, publicKey);
        crypt.decryptFile(encryptedFileName, decryptedFileName, privateKey);

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println("Work time: " + executionTime + " ms");
    }
}
