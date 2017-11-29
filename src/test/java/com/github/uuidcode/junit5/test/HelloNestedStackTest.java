package com.github.uuidcode.junit5.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.EmptyStackException;
import java.util.Stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("스택을 테스트합니다.")
public class HelloNestedStackTest {
    private Stack<String> stack = new Stack<>();

    @Nested @DisplayName("스택이 비어 있을때")
    class EmptyStack {
        @Test @DisplayName("아이템이 없어야 합니다.")
        public void isEmpty() {
            assertTrue(stack.isEmpty());
        }

        @Test @DisplayName("아이템을 꺼낼려고하면 오류가 발생합니다.")
        public void throwsExceptionWhenPopped() {
            assertThrows(EmptyStackException.class, () -> stack.pop());
        }
    }

    @Nested @DisplayName("스택에 아이템이 한개가 들어가 있을때")
    class OneItemStack {
        @BeforeEach
        public void beforeEach() {
            stack.add("Java");
        }

        @Test @DisplayName("아이템이 있어야합니다.")
        public void isEmpty() {
            assertFalse(stack.isEmpty());
        }

        @Test @DisplayName("아이템을 꺼낼 수 있습니다.")
        public void throwsExceptionWhenPopped() {
            assertEquals(stack.pop(), "Java");
        }
    }
}
