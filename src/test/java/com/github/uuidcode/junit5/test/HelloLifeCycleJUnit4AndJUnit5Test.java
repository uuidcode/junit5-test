package com.github.uuidcode.junit5.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HelloLifeCycleJUnit4AndJUnit5Test {
    @BeforeClass /* junit4 */ @BeforeAll /* junit5 */ @DisplayName("모든 테스트 케이스가 실행되기 전에 실행됩니다.")
    public static void beforeAll() {
        System.out.println("@BeforeAll");
    }

    @AfterClass /* junit4 */ @AfterAll /* junit5 */ @DisplayName("모든 테스트 케이스가 실행된 후에 실행됩니다.")
    public static void afterAll() {
        System.out.println("@AfterAll");
    }

    @Before /* junit4 */ @BeforeEach /* junit5 */ @DisplayName("각 테스트 케이스가 실행되기 전에 실행됩니다.")
    public void beforeEach() {
        System.out.println("    @BeforeEach");
    }

    @After /* junit4 */  @AfterEach /* junit5 */ @DisplayName("각 테스트 케이스가 실행된 후에 실행됩니다.")
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
