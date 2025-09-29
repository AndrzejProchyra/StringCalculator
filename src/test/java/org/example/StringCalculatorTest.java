package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {
    @Test
    void add_empty_string() {
        assertThat(new StringCalculator().add("")).isEqualTo(0);
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

    @Test
    void add_three_numbers() {
        assertThat(new StringCalculator().add("1,2,3")).isEqualTo(6);
        assertThat(new StringCalculator().add("1,2,4")).isEqualTo(7);
    }

    @Test
    void add_seven_numbers() {
        assertThat(new StringCalculator().add("2,5,8,1,9,3,7"))
                .isEqualTo(35);
    }
}
