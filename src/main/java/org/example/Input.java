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
        return getNewNumbers().split(newDelimiter + "|\n");
    }

    private static String handleMetacharacters(String newDelimiter) {
        newDelimiter = newDelimiter.replace("*", "\\*");
        newDelimiter = newDelimiter.replace("|", "\\|");
        newDelimiter = newDelimiter.replace(".", "\\.");
        return newDelimiter;
    }

    private static String removeSurroundingSquareBrackets(String newDelimiter) {
        if (newDelimiter.startsWith("[")) {
            newDelimiter = newDelimiter.substring(1, newDelimiter.indexOf("]"));
        }
        return newDelimiter;
    }

    private String getNewDelimiter() {
        boolean hasNewDelimiter = input.startsWith("//");
        String delimiter = ",";
        if (hasNewDelimiter) {
            delimiter = input.substring(2, getNewLineIndex());
            delimiter = handleMetacharacters(delimiter);
        }
        return removeSurroundingSquareBrackets(delimiter);
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
