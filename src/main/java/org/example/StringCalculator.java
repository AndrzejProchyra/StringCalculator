package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class StringCalculator {
    private List<AddOccurredSubscriber> addOccurredSubscribers = new ArrayList<>();

    private int callCount = 0;

    public int add(String numbers) {
        callCount++;
        notifySubscribers();
        int sum = 0;
        for (int n : parse(numbers)) {
            sum += n;
        }
        return sum;
    }

    private void notifySubscribers() {
        addOccurredSubscribers.forEach(AddOccurredSubscriber::handleAddOccurredEvent);
    }

    private static int[] parse(String numbers) {
        String delimiter = ",";
        boolean hasNewDelimiter = numbers.startsWith("//");
        delimiter = getNewDelimiter(numbers, hasNewDelimiter, delimiter);
        numbers = getNewNumbers(numbers, hasNewDelimiter);

        if (numbers.isEmpty())
            return new int[0];

        String[] splitNumbers = numbers.split("[" + delimiter + "\n]");
        int[] splitNumbersAsInt = Arrays.stream(splitNumbers).mapToInt(Integer::parseInt).toArray();

        requireNonNegatives(splitNumbersAsInt);
        return splitNumbersAsInt;
    }

    private static void requireNonNegatives(int[] applesauce) {
        List<Integer> negatives = new ArrayList<>();
        for (int n : applesauce) {
            if (n < 0) {
                negatives.add(n);
            }
        }
        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("Negatives not allowed: " + toCommaDelimitedString(negatives));
        }
    }

    private static String toCommaDelimitedString(List<Integer> nums) {
        return nums.stream()
                .map(String::valueOf)
                .collect(joining(", "));
    }

    private static String getNewNumbers(String numbers, boolean hasNewDelimiter) {
        if (hasNewDelimiter) {
            numbers = numbers.substring(4);
        }
        return numbers;
    }

    private static String getNewDelimiter(String numbers, boolean hasNewDelimiter, String delimiter) {
        if (hasNewDelimiter) {
            delimiter = String.valueOf(numbers.charAt(2));
        }
        return delimiter;
    }

    public int getCalledCount() {
        return callCount;
    }

    public void subscribe(AddOccurredSubscriber subscriber) {
        addOccurredSubscribers.add(subscriber);
    }
}
