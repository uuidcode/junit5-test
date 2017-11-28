package com.github.uuidcode.junit5.test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloUITest {
    @UITest
    public void buttonIsNotNull() {
        assertThat("button").isNotNull();
    }
}
