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
        assertThat(new StringCalculator().add(number)).isEqualTo(expected);
    }

    @Test
    void add_two_numbers() {
        assertThat(new StringCalculator().add("1,2")).isEqualTo(3);
    }

    @ParameterizedTest
    @MethodSource("provideNumberStrings")
    void add_unknown_amount_of_numbers(String numbers, int expected) {
        assertThat(new StringCalculator().add(numbers))
                .isEqualTo(expected);
    }

    private static Stream<Arguments> provideNumberStrings() {
        return Stream.of(
                Arguments.of("1,2,3", 6),
                Arguments.of("2,5,8,1,9,3,7", 35)
        );
    }

    @Test
    void add_two_numbers_separated_by_a_newline() {
        assertThat(new StringCalculator().add("1\n2"))
                .isEqualTo(3);
    }
}
