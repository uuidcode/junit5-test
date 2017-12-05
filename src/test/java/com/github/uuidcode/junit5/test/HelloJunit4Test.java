package com.github.uuidcode.junit5.test;

import static org.junit.Assert.assertEquals;

import java.util.stream.IntStream;

import org.junit.Test;

public class HelloJunit4Test {
    @Test
    public void 테스트_1에서_10까지_더하면_55입니다() {
        assertEquals(IntStream.rangeClosed(1, 10).sum(), 55);
    }
}
