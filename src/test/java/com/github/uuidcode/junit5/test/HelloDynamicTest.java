package com.github.uuidcode.junit5.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

public class HelloDynamicTest {

    @TestFactory
    @DisplayName("테스트를 만들어보자1.")
    public Stream<DynamicTest> test1() {
        return Stream.of(dynamicTest("테스트 메서드 이름 만들기가 귀찮아1.",
            () -> {
                assertEquals(2, 1 + 1);
            }));
    }

    @TestFactory
    @DisplayName("테스트를 만들어보자2.")
    public Stream<DynamicTest> test2() {
        return Stream.of(dynamicTest("테스트 메서드 이름 만들기가 귀찮아2.",
            () -> {
                assertEquals(2, 1 + 1);
            }));
    }
}
