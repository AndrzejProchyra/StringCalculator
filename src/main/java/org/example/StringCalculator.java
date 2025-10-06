package org.example;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.isEmpty())
            return 0;

        String[] splitNumbers = numbers.split("[,\n]");

        int sum = 0;
        for (String splitNumber : splitNumbers) {
            sum += Integer.parseInt(splitNumber);
        }
        return sum;
    }
}
