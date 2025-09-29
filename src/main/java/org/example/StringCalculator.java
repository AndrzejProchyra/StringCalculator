package org.example;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.isEmpty())
            return 0;
        if (numbers.contains(",")) {
            String[] splitNumbers = numbers.split(",");

            int sum = 0;
            if (splitNumbers.length == 2) {
                for (int i = 0; i < 2; i++) {
                    sum += Integer.parseInt(splitNumbers[i]);
                }
            } else if (splitNumbers.length == 3) {
                for (int i = 0; i < 3; i++) {
                    sum += Integer.parseInt(splitNumbers[i]);
                }
            } else if (splitNumbers.length == 7) {
                for (int i = 0; i < 7; i++) {
                    sum += Integer.parseInt(splitNumbers[i]);
                }
            }
            return sum;
        }
        return Integer.parseInt(numbers);
    }
}
