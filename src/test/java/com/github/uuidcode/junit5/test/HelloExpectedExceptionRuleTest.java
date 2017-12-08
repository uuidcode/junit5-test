package com.github.uuidcode.junit5.test;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class HelloExpectedExceptionRuleTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void withRule() {
        expectedException.expect(NumberFormatException.class);
        expectedException.expectMessage("For input string: \"가\"");
        Integer.parseInt("가");
    }

    @Test
    public void tryAndCatch() {
        try {
            Integer.parseInt("가");
        } catch (Throwable t) {
            assertEquals(t.getClass(), NumberFormatException.class);
            assertEquals(t.getMessage(), "For input string: \"가\"");
        }
    }
}
