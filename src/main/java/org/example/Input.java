package org.example;

public class Input {
    private final String input;

    public Input(String input) {
        this.input = input;
    }

    public String getInput() {
        return input;
    }

    String getNewDelimiter(boolean hasNewDelimiter) {
        String delimiter = ",";
        if (hasNewDelimiter) {
            delimiter = String.valueOf(getInput().charAt(2));
        }
        return delimiter;
    }
}
