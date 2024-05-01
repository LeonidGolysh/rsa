package org.example.write;

public class ConvertToArray {

    public String arrayToString(int[] array) {
        StringBuilder result = new StringBuilder();
        for (int num : array) {
            result.append(num).append(" ");
        }
        return result.toString();
    }

    public int[] stringToArray(String str) {
        String[] parts = str.trim().split("\\s+");
        int[] array = new int[parts.length];

        for (int i = 0; i < parts.length; i++) {
            array[i] = Integer.parseInt(parts[i]);
        }
        return array;
    }
}
