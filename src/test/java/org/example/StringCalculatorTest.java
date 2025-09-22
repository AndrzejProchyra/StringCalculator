package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {
    @Test
    void add_test() {
        assertThat(new StringCalculator().add("")).isEqualTo(0);
    }

    @Test
    void add_one_number() {
        assertThat(new StringCalculator().add("1")).isEqualTo(1);
    }
}
