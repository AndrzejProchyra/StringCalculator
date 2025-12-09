package org.example;

public class Input {
    private final String input;

    public Input(String input) {
        this.input = input;
    }

    String[] getSplitNumbers() {
        if (input.isEmpty()) {
            return new String[0];
        }
        String newDelimiter = getNewDelimiter();
        if (newDelimiter.startsWith("[")) {
            newDelimiter = newDelimiter.replace("[", "");
            newDelimiter = newDelimiter.replace("]", "");
        }
        if (newDelimiter.equals("|"))
            newDelimiter = "\\|";
        if (newDelimiter.equals("*"))
            newDelimiter = "\\*";
        return getNewNumbers().split(newDelimiter + "|\n");
    }

    private String getNewDelimiter() {
        boolean hasNewDelimiter = input.startsWith("//");
        String delimiter = ",";
        if (hasNewDelimiter) {
            delimiter = input.substring(2, getNewLineIndex());
        }
        return delimiter;
    }

    private String getNewNumbers() {
        boolean hasNewDelimiter = input.startsWith("//");
        String numbers = input;
        if (hasNewDelimiter) {
            numbers = input.substring(getNewLineIndex() + 1);
        }
        return numbers;
    }

    private int getNewLineIndex() {
        return input.indexOf("\n");
    }
}
