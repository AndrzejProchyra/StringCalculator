package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import static org.assertj.core.api.Assertions.*;

class MainTest {

    @BeforeEach
    void setUp() {
        // Setup code before each test
    }

    @AfterEach
    void tearDown() {
        // Cleanup code after each test
    }

    @Test
    @DisplayName("Sample test demonstrating JUnit Jupiter and AssertJ")
    void sampleTest() {
        // Arrange
        String expected = "Hello world!";
        String actual = "Hello world!";

        // Act & Assert
        assertThat(actual).isEqualTo(expected);
        assertThat(actual).isNotNull();
        assertThat(actual).startsWith("Hello");
        assertThat(actual).endsWith("!");
        assertThat(actual).hasSize(12);
    }

    @Test
    @DisplayName("Test with numbers using AssertJ")
    void testNumbers() {
        // Arrange
        int value = 42;

        // Act & Assert
        assertThat(value)
            .isEqualTo(42)
            .isGreaterThan(40)
            .isLessThan(50)
            .isPositive();
    }

    @Test
    @DisplayName("Test with collections using AssertJ")
    void testCollections() {
        // Arrange
        java.util.List<String> list = java.util.Arrays.asList("apple", "banana", "cherry");

        // Act & Assert
        assertThat(list)
            .hasSize(3)
            .contains("banana")
            .containsExactly("apple", "banana", "cherry")
            .doesNotContain("orange");
    }
}