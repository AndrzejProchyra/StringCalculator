package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {
    @Test
    void add_empty_string() {
        assertThat(new StringCalculator().add("")).isEqualTo(0);
    }

    @Test
    void add_number_1() {
        assertThat(new StringCalculator().add("1")).isEqualTo(1);
    }

    @Test
    void add_number_2() {
        assertThat(new StringCalculator().add("2")).isEqualTo(2);
    }
}
