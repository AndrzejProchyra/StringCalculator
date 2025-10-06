package org.example;

public class StringCalculator {
    public int add(String numbers) {
        String delimiter = ",";
        boolean hasNewDelimiter = numbers.startsWith("//");
        if (hasNewDelimiter) {
            delimiter = String.valueOf(numbers.charAt(2));
            numbers = numbers.substring(4);
        }

        if (numbers.isEmpty())
            return 0;

        String[] splitNumbers = numbers.split("[" + delimiter + "\n]");

        int sum = 0;
        for (String splitNumber : splitNumbers) {
            sum += Integer.parseInt(splitNumber);
        }
        return sum;
    }
}
