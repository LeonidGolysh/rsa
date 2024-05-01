package org.example.crypt;

import org.example.write.ConvertToArray;

import java.io.*;
import java.math.BigInteger;

public class Crypt {
    private static final ConvertToArray convertToArray = new ConvertToArray();

    public void encryptFile(String inputFileName, String outputFileName, BigInteger[] publicKey) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));

            String line;
            while ((line = reader.readLine()) != null) {
                int[] encryptedMessage = encrypt(line, publicKey);
                String encryptedLine = convertToArray.arrayToString(encryptedMessage);
                writer.write(encryptedLine);
                writer.newLine();
            }

            reader.close();
            writer.close();
            System.out.println("File encrypted successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void decryptFile(String inputFileName, String outputFileName, BigInteger[] privateKey) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));

            String line;
            while ((line = reader.readLine()) != null) {
                int[] encryptedMessage = convertToArray.stringToArray(line);
                String decryptedLine = decrypt(encryptedMessage, privateKey);
                writer.write(decryptedLine);
                writer.newLine();
            }

            reader.close();
            writer.close();
            System.out.println("File decrypted successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
