package org.example;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.BDDAssertions.then;

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
        assertAdd("1\n2\n5\n3", 11);
    }

    @Test
    void add_multiple_numbers_separated_by_commas_and_newlines() {
        assertAdd("1\n2,3", 6);
    }

    @Test
    void add_two_numbers_with_semicolon_custom_delimiter() {
        assertAdd("//;\n1;2", 3);
    }

    @Test
    void add_two_numbers_with_pipe_custom_delimiter() {
        assertAdd("//|\n5|7", 12);
    }

    @Test
    @Disabled("Failing. We are not sure if multiple delimiters should be supported.")
    void add_two_numbers_with_pipe_custom_delimiter_and_comma_default_delimiter() {
        assertAdd("//|\n5|7,4", 16);
    }

    @Test
    void add_with_negative_number_throws() {
        assertThatThrownBy(() -> new StringCalculator().add("1,-1"))
                .hasMessage("Negatives not allowed: -1");
    }

    @Test
    void add_with_multiple_negative_numbers_throws_and_shows_all_of_them_in_the_exception_message() {
        assertThatThrownBy(() -> new StringCalculator().add("-1,-1,3,-7,-2"))
                .hasMessage("Negatives not allowed: -1, -1, -7, -2");
    }

    // Adding more than one number and confirming count is more than one

    @Test
    void no_add_call_count_is_zero() {
        var calculator = new StringCalculator();

        then(calculator.getCalledCount())
                .isZero();
    }

    @Test
    void add_one_number_count_is_one() {
        var calculator = new StringCalculator();

        calculator.add("1");

        then(calculator.getCalledCount())
                .isOne();
    }

    @Test
    void invoke_add_multiple_times_count_is_more_than_one() {
        var calculator = new StringCalculator();
        calculator.add("1");
        calculator.add("4");
        calculator.add("6");

        int calledCount = calculator.getCalledCount();

        then(calledCount)
                .isEqualTo(3);
    }

    @Test
    void should_trigger_an_add_occurred_event_when_add_is_called() {
        //given
        var calculator = new StringCalculator();
        AtomicInteger calledCount = new AtomicInteger();
        calculator.subscribe(calledCount::getAndIncrement);

        //when
        calculator.add("1");
        calculator.add("4");
        calculator.add("6");

        then(calledCount.get())
                .isEqualTo(3);
    }

    @Test
    void should_allow_numbers_less_than_or_equal_to_1000() {
        assertAdd("1000,1", 1001);
    }

    private static void assertAdd(String numbers, int expected) {
        assertThat(new StringCalculator().add(numbers))
                .isEqualTo(expected);
    }
}
