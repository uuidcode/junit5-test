package com.github.uuidcode.junit5.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.Duration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("assert를 테스트합니다.")
public class HelloAssertTest {
    @Test
    @DisplayName("다양한 assertions")
    public void test() {
        assertEquals(2, 1 + 1);
        assertEquals(new Author(), new Author());
        assertTrue(true);
        assertFalse(false);

        Author author = new Author().setName("Java");
        Author anotherAuthor = author;

        assertSame(author, anotherAuthor);
        assertNull(null);
        assertNotNull("java");

        NumberFormatException exception = assertThrows(NumberFormatException.class, () -> {
            Integer.parseInt("가");
        });

        assertEquals("For input string: \"가\"", exception.getMessage());

        assertTimeout(Duration.ofSeconds(1), () -> {
            Thread.sleep(700);
        });

        fail("error");
    }
}
