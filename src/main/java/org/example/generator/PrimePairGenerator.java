package org.example.generator;

import java.util.Random;

public class PrimePairGenerator {
    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        if (number <= 3) {
            return true;
        }
        if (number % 2 == 0 || number % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= number; i = i + 6) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    public static int generatePrime(int min, int max) {
        Random random = new Random();
        int num;

        do {
            num = random.nextInt((max - min) + 1) + min;
        } while (!isPrime(num));
        return num;

    }

    public static int[] generatePrimePair(int min, int max) {
        int p = generatePrime(min, max);
        int q;

        do {
            q = generatePrime(min, max);
        } while (p == q); // Check that q different from p
        return new int[]{p, q};
    }
}
