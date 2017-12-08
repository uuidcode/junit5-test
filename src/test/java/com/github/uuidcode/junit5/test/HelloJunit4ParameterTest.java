package com.github.uuidcode.junit5.test;

import org.junit.Test;

public class HelloJunit4ParameterTest {
    @Test
    public void test(String name) {
        System.out.println(name);
    }
}
