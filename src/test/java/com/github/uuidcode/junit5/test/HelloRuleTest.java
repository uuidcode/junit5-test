package com.github.uuidcode.junit5.test;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

public class HelloRuleTest {
    @Rule
    public Timeout timeoutRule = new Timeout(1000, TimeUnit.MILLISECONDS);

    @Rule
    public ExpectedException expectedExceptionRule = ExpectedException.none();

    @Test
    public void timeoutFail() throws Exception {
        Thread.sleep(1001);
    }

    @Test
    public void tryAndCatch() {
        try {
            Integer.parseInt("가");
        } catch (Throwable t) {
            assertEquals(NumberFormatException.class, t.getClass());
            assertEquals("For input string: \"가\"", t.getMessage());
        }
    }

    @Test(expected = NumberFormatException.class)
    public void expected() {
        Integer.parseInt("가");
    }

    @Test
    public void withExpectedExceptionRule() {
        expectedExceptionRule.expect(NumberFormatException.class);
        expectedExceptionRule.expectMessage("For input string: \"가\"");
        Integer.parseInt("가");
    }
}
