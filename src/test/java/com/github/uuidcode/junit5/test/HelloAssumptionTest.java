package com.github.uuidcode.junit5.test;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class HelloAssumptionTest {
    @BeforeAll
    public static void beforeAll() {
        assumeTrue("sandbox".equals(System.getenv("buildPhase")));
    }

    @Test
    @Tag("assume")
    public void test() {
        System.out.println("test1");
    }

    @Test
    @Tag("assume")
    public void test2() {
        System.out.println("test2");
    }
}
