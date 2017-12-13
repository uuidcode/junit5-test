package com.github.uuidcode.junit5.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;

public class HelloTestInfoTest {
    @Test
    @DisplayName("Hello TestInfo")
    @Tag("integration")
    public void test(TestInfo testInfo) {
        System.out.println("getDisplayName(): " + testInfo.getDisplayName());
        System.out.println("getTags(): " + testInfo.getTags());
        System.out.println("getTestClass(): " + testInfo.getTestClass());
        System.out.println("getTestMethod(): " + testInfo.getTestMethod());
    }
}
