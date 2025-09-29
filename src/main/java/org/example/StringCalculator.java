package org.example;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.isEmpty())
            return 0;
        if (numbers.contains(",")) {
            String[] splitNumbers = numbers.split(",");

            int sum = 0;
            if (splitNumbers.length == 2) {
                sum += Integer.parseInt(splitNumbers[0]) + Integer.parseInt(splitNumbers[1]);
            } else {
                sum += Integer.parseInt(splitNumbers[0]) + Integer.parseInt(splitNumbers[1]) + Integer.parseInt(splitNumbers[2]);
            }
            return sum;
        }
        return Integer.parseInt(numbers);
    }
}
