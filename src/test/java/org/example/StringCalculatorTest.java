package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {
    @Test
    void add_empty_string() {
        assertThat(new StringCalculator().add("")).isZero();
    }

    @ParameterizedTest(name = "Adding \"{0}\" gives {1}")
    @CsvSource({
            "1, 1",
            "2, 2",
            "3, 3",
    })
    void add_one_number(String number, int expected) {
        assertAdd(number, expected);
    }

    @Test
    void add_two_numbers() {
        assertAdd("1,2", 3);
    }

    @ParameterizedTest
    @MethodSource("provideNumberStrings")
    void add_unknown_amount_of_numbers(String numbers, int expected) {
        assertAdd(numbers, expected);
    }

    private static Stream<Arguments> provideNumberStrings() {
        return Stream.of(
                Arguments.of("1,2,3", 6),
                Arguments.of("2,5,8,1,9,3,7", 35)
        );
    }

    @Test
    void add_two_numbers_separated_by_a_newline() {
        assertAdd("1\n2", 3);
    }

    @Test
    void add_multiple_numbers_separated_by_commas_and_newlines() {
        assertAdd("1\n2,3", 6);
    }

    private static void assertAdd(String numbers, int expected) {
        assertThat(new StringCalculator().add(numbers))
                .isEqualTo(expected);
    }
}
