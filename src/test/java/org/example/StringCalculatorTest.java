package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {
    @Test
    void add_test() {
        assertThat(new StringCalculator().add("")).isEqualTo(0);
    }
}
