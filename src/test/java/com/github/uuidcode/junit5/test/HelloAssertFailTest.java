package com.github.uuidcode.junit5.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class HelloAssertFailTest {
    @Test
    public void test() {
        assertEquals(0, 1 + 1);
        assertEquals(1, 1 + 1);
        assertEquals(2, 1 + 1);
    }
}
