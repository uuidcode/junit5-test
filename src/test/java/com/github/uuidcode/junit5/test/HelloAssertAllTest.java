package com.github.uuidcode.junit5.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class HelloAssertAllTest {
    @Test
    public void test() {
        assertAll(
            () -> assertEquals(0, 1 + 1),
            () -> assertEquals(1, 1 + 1),
            () -> assertEquals(2, 1 + 1));
    }
}
