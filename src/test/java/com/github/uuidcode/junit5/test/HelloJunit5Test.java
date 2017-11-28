package com.github.uuidcode.junit5.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.IntStream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@DisplayName("JUnit5를 테스트합니다.")
public class HelloJunit5Test {
    @RepeatedTest(10)
    public void repeatedTest() {
        assertThat("Hello").isNotNull();
        System.out.println(">>> hello");
    }

    @Test
    @DisplayName("안녕하세요.")
    @Tag("slow")
    public void hello() {
        assertThat("Hello").isNotNull();
        System.out.println(">>> hello");
    }

    @Test
    @DisplayName("1부터 10까지 더하면 55입니다.")
    @Tag("fast")
    public void sum() {
        assertThat(IntStream.rangeClosed(1, 10).sum()).isEqualTo(55);
        System.out.println(">>> sum");
    }

    @Test
    @DisplayName("값이 null이여야 합니다.")
    @Disabled("고쳐주세요.")
    public void fixMe() {
        assertThat("fixMe").isNull();
        System.out.println(">>> fixme");
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("beforeAll");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("afterAll");
    }

    @BeforeEach
    public  void beforeEach() {
        System.out.println("beforeEach");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("afterEach");
    }
}
