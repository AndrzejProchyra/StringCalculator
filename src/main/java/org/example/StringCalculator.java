package org.example;

public class StringCalculator {
    public int add(String numbers) {
        String newDelimiter = "";
        boolean hasNewDelimiter = numbers.startsWith("//");
        if (hasNewDelimiter) {
            newDelimiter = String.valueOf(numbers.charAt(2));
        }

        if (numbers.isEmpty())
            return 0;

        String[] splitNumbers = numbers.split("[,\n]");
        if (hasNewDelimiter) {
            splitNumbers = numbers.substring(4).split("[,\n" + newDelimiter + "]");
        }

        int sum = 0;
        for (String splitNumber : splitNumbers) {
            sum += Integer.parseInt(splitNumber);
        }
        return sum;
    }
}
