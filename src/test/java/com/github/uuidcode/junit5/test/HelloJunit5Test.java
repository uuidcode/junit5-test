package com.github.uuidcode.junit5.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@DisplayName("JUnit5를 테스트합니다.")
public class HelloJunit5Test {
    @Test
    @DisplayName("안녕하세요.")
    @Tag("slow")
    public void hello() {
        assertNotNull("Hello");
    }

    @Test
    @DisplayName("1부터 10까지 더하면 55입니다.")
    @Tag("fast")
    public void sum() {
        assertEquals(55, IntStream.rangeClosed(1, 10).sum());
        System.out.println(">>> sum");
    }

    @RepeatedTest(10)
    @DisplayName("반복테스트")
    @Disabled("고쳐주세요.")
    public void repeatedTest() {
        assertNotNull("Hello");
    }

    @Test
    @DisplayName("에러처리")
    public void exceptionTest() {
        Exception exception = assertThrows(NumberFormatException.class, () -> {
            Integer.parseInt("가");
        });

        assertEquals("For input string: \"가\"", exception.getMessage());
    }
}
