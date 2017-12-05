package com.github.uuidcode.junit5.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(HelloExtension.class)
public class HelloExtendWithTest {
    @BeforeEach
    public void beforeEach() {
        System.out.println("-->");
    }

    @Test
    public void test1() {
        System.out.println("test1");
    }

    @Test
    @ExtendWith(HelloMethodExtension.class)
    public void test2() {
        System.out.println("test2");
    }
}
