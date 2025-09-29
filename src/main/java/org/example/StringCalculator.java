package org.example;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.isEmpty())
            return 0;
        if (numbers.contains(",")) {
            String[] splitNumbers = numbers.split(",");
            if (splitNumbers.length == 2)
                return Integer.parseInt(splitNumbers[0]) + Integer.parseInt(splitNumbers[1]);
            return Integer.parseInt(splitNumbers[0]) + Integer.parseInt(splitNumbers[1]) + Integer.parseInt(splitNumbers[2]);
        }
        return Integer.parseInt(numbers);
    }
}
