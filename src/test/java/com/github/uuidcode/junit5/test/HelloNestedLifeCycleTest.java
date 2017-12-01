package com.github.uuidcode.junit5.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import com.google.gson.GsonBuilder;

public class HelloNestedLifeCycleTest {
    private static List<String> list = new ArrayList<>();

    @BeforeAll
    public static void beforeAll() {
        list.add("beforeAll");
    }

    @BeforeEach
    public void beforeEach() {
        list.add("beforeEach");
    }

    @AfterAll
    public static void afterAll() {
        List<String> expectedList = new ArrayList<>();
        expectedList.add("beforeAll");
        expectedList.add("Nested1 beforeAll");
        expectedList.add("beforeEach");
        expectedList.add("Nested1 beforeEach");
        expectedList.add("Nested1 abc");
        expectedList.add("beforeEach");
        expectedList.add("Nested1 beforeEach");
        expectedList.add("Nested1 test1");
        expectedList.add("beforeEach");
        expectedList.add("Nested1 beforeEach");
        expectedList.add("Nested1 test2");
        expectedList.add("Nested1 afterAll");
        assertEquals(toJson(expectedList), toJson(list));
    }

    public static String toJson(Object object) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(object);
    }

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class Nested1 {
        @BeforeAll
        public void beforeAll() {
            list.add("Nested1 beforeAll");
        }

        @BeforeEach
        public void beforeEach() {
            list.add("Nested1 beforeEach");
        }

        @AfterAll
        public void afterAll() {
            list.add("Nested1 afterAll");
        }

        @Test
        public void test1() {
            list.add("Nested1 test1");
        }

        @Test
        public void test2() {
            list.add("Nested1 test2");
        }

        @Test
        public void abc() {
            list.add("Nested1 abc");
        }
    }
}
