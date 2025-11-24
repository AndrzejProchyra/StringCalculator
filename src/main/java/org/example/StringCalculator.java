package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

public class StringCalculator {
    private List<AddOccurredSubscriber> addOccurredSubscribers = new ArrayList<>();

    private int callCount = 0;

    private int[] parse(String input) { // todo: Long Method
        Input wrappedInput = new Input(input);
        boolean hasNewDelimiter = wrappedInput.getInput().startsWith("//");
        // parse should take in an input because it includes "delimiter" + "numbers"
        // can create new Input, or instance of some other class that wraps the String input
        // this instance might return a regex or just the collection of integers

        // These are the intermediary steps that we have right now
        // getNewNumbers returns "1,2,3,4" (assuming comma delimiter)
        // splitNumbers is then ["1", "2", "3", "4"]
        // We stream this and map to int to get a stream of integers
        // We convert the stream to [1, 2, 3, 4]

        String delimiter = wrappedInput.getNewDelimiter(hasNewDelimiter); // todo: boolean parameter
        String numbers = getNewNumbers(wrappedInput.getInput(), hasNewDelimiter); // todo: boolean parameter

        if (wrappedInput.getInput().isEmpty())
            return new int[0];

        String[] splitNumbers = numbers.split("[" + delimiter + "\n]");
        IntStream intStream = Arrays.stream(splitNumbers).mapToInt(Integer::parseInt);

        intStream = intStream.filter(n -> n <= 1000);

        int[] splitNumbersAsInt = intStream.toArray();
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

    public int getCalledCount() {
        return callCount;
    }

    public void subscribe(AddOccurredSubscriber subscriber) {
        addOccurredSubscribers.add(subscriber);
    }
}
