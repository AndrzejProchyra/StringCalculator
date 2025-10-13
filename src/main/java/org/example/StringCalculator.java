package org.example;

public class StringCalculator {
    public int add(String numbers) {
        String delimiter = ",";
        boolean hasNewDelimiter = numbers.startsWith("//");
        delimiter = getNewDelimiter(numbers, hasNewDelimiter, delimiter);
        numbers = getNewNumbers(numbers, hasNewDelimiter);

        if (numbers.isEmpty())
            return 0;

        String[] splitNumbers = numbers.split("[" + delimiter + "\n]");

        int sum = 0;
        for (String splitNumber : splitNumbers) {
            int n = Integer.parseInt(splitNumber);
            requireNonNegative(n);
            sum += n;
        }
        return sum;
    }

    private static String getNewNumbers(String numbers, boolean hasNewDelimiter) {
        if (hasNewDelimiter) {
            numbers = numbers.substring(4);
        }
        return numbers;
    }

    private static String getNewDelimiter(String numbers, boolean hasNewDelimiter, String delimiter) {
        if (hasNewDelimiter) {
            delimiter = String.valueOf(numbers.charAt(2));
        }
        return delimiter;
    }

    private static void requireNonNegative(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Negatives not allowed: " + n);
        }
    }
}
