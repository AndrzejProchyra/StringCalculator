package org.example;

public class Input {
    private final String input;

    public Input(String input) {
        this.input = input;
    }

    String getNewDelimiter() {
        boolean hasNewDelimiter = input.startsWith("//");
        String delimiter = ",";
        if (hasNewDelimiter) {
            delimiter = String.valueOf(input.charAt(2));
        }
        return delimiter;
    }

    String getNewNumbers() {
        boolean hasNewDelimiter = input.startsWith("//");
        String numbers = input;
        if (hasNewDelimiter) {
            numbers = input.substring(4);
        }
        return numbers;
    }

    String[] getSplitNumbers() {
        if (input.isEmpty()) {
            return new String[0];
        }
        return getNewNumbers().split("[" + getNewDelimiter() + "\n]");
    }
}
