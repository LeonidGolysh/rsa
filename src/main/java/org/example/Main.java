package org.example;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        KeysGenerator keysGenerator = new KeysGenerator();
        Crypt crypt = new Crypt();

        int p = 61;
        int q = 53;

        BigInteger[] publicKey = keysGenerator.generatePublicKey(p, q);
        BigInteger[] privateKey = keysGenerator.generatePrivateKey(p, q);

        System.out.println("Public key (e, n): (" + publicKey[0] + ", " + publicKey[1] + ")");
        System.out.println("Private key (d, n): (" + privateKey[0] + ", " + privateKey[1] + ")");

        String message = "Hello World!";
        System.out.println("Message for encrypt: " + message);

        int[] encryptedMessage = crypt.encrypt(message, publicKey);
        System.out.println("Encrypted message: " + encryptedMessage);

        String decryptedMessage = crypt.decrypt(encryptedMessage, privateKey);
        System.out.println("Decrypted message: " + decryptedMessage);
    }
}