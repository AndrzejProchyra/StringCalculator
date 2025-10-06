package org.example;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.isEmpty())
            return 0;
        if (numbers.contains(",")) {
            String[] splitNumbers = numbers.split("[,\n]");

            int sum = 0;
            for (String splitNumber : splitNumbers) {
                sum += Integer.parseInt(splitNumber);
            }
            return sum;
        }
        if (numbers.contains("\n")) {
            String[] splitNumbers = numbers.split("\n");

            int sum = 0;
            for (String splitNumber : splitNumbers) {
                sum += Integer.parseInt(splitNumber);
            }
            return sum;
        }
        return Integer.parseInt(numbers);
    }
}
