package com.github.uuidcode.junit5.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class HelloUITest {
    @UITest
    public void buttonIsNotNull() {
        assertNotNull("button");
    }
}
