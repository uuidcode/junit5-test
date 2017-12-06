package com.github.uuidcode.junit5.test;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.Test;

public class HelloAssumptionTest {
    @Test
    public void test() {
        assumeTrue(false);
        System.out.println("test");
    }
}
