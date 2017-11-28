package com.github.uuidcode.junit5.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.EmptyStackException;
import java.util.Stack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("스택을 테스트합니다.")
public class HelloStackTest {
    @Test @DisplayName("비어있는 스택은 아이템이 없어야 합니다.")
    public void isEmpty() {
        assertTrue(new Stack().isEmpty());
    }

    @Test @DisplayName("비어있는 스택에서 아이템을 꺼낼려고 하면 오류가 발생합니다.")
    public void throwsExceptionWhenPopped() {
        Stack stack = new Stack();
        assertThrows(EmptyStackException.class, () -> stack.pop());
    }

    @Test @DisplayName("아이템이 하나가 들어가 있는 스택은 비어있지 않습니다.")
    public void isNotEmpty() {
        Stack<String> stack = new Stack<>();
        stack.push("Java");
        assertFalse(stack.isEmpty());
    }

    @Test @DisplayName("아이템이 하나가 들어가 있는 스택에서 아이템을 꺼낼 수 있습니다.")
    public void pop() {
        Stack<String> stack = new Stack<>();
        stack.push("Java");
        assertEquals(stack.pop(), "Java");
    }
}
