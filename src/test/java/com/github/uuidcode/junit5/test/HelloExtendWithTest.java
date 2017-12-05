package com.github.uuidcode.junit5.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(HelloExtension.class)
public class HelloExtendWithTest {
    @Test
    public void test() {
        System.out.println("test");
    }
}
