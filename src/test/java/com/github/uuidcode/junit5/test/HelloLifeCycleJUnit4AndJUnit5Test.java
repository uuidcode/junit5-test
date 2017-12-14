package com.github.uuidcode.junit5.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HelloLifeCycleJUnit4AndJUnit5Test {
    @BeforeClass @BeforeAll
    public static void beforeAll() {
        System.out.println("@BeforeAll");
    }

    @AfterClass @AfterAll
    public static void afterAll() {
        System.out.println("@BeforeAll");
    }

    @Before @BeforeEach
    public void beforeEach() {
        System.out.println("    @BeforeEach");
    }

    @After @AfterEach
    public void afterEach() {
        System.out.println("    @AfterEach");
    }

    @Test
    public void test1() {
        System.out.println("        test1");
    }

    @Test
    public void test2() {
        System.out.println("        test2");
    }
}
