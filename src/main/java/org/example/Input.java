package org.example;

public class Input {
    private final String input;

    public Input(String input) {
        this.input = input;
    }

    public String getInput() {
        return input;
    }

    String getNewDelimiter() {
        boolean hasNewDelimiter = input.startsWith("//");
        String delimiter = ",";
        if (hasNewDelimiter) {
            delimiter = String.valueOf(getInput().charAt(2));
        }
        return delimiter;
    }

    String getNewNumbers() {
        boolean hasNewDelimiter = getInput().startsWith("//");
        String numbers = getInput();
        if (hasNewDelimiter) {
            numbers = getInput().substring(4);
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
