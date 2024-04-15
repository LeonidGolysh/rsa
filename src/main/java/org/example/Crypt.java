package org.example;

import java.math.BigInteger;

public class Crypt {

//     Encrypt the message using the public key
    public int[] encrypt(String message, BigInteger[] publicKey) {
        BigInteger e = publicKey[0];
        BigInteger n = publicKey[1];
        int[] encryptedMessage = new int[message.length()];

        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            encryptedMessage[i] = BigInteger.valueOf((int) c).modPow(e, n).intValue();
        }
        return encryptedMessage;

    }

    // Decrypt the message using the private key
    public String decrypt(int[] encryptedMessage, BigInteger[] privateKey) {
        BigInteger d = privateKey[0];
        BigInteger n = privateKey[1];
        StringBuilder decryptedMessage = new StringBuilder();

        for (int encryptedChar : encryptedMessage) {
            BigInteger decryptedValue = BigInteger.valueOf(encryptedChar).modPow(d, n);
            decryptedMessage.append((char) decryptedValue.intValue());
        }
        return decryptedMessage.toString();
    }
}
