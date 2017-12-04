package com.github.uuidcode.junit5.test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class HelloTestInstancePerClassTest {
    @BeforeAll
    public void beforeAll() {
        System.out.println("beforeAll");
    }

    @Test
    public void test1() {
        System.out.println(this);
    }

    @Test
    public void test2() {
        System.out.println(this);
    }
}
