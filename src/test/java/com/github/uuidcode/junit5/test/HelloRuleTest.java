package com.github.uuidcode.junit5.test;

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
    public void success() throws Exception {
        Thread.sleep(100);
    }

    @Test
    public void fail() throws Exception {
        Thread.sleep(1001);
    }

    @Test
    public void throwsNullPointerException() {
        expectedExceptionRule.expect(NullPointerException.class);
        throw new NullPointerException();
    }

    @Test
    public void throwsNullPointerExceptionWithMessage() {
        expectedExceptionRule.expect(NullPointerException.class);
        expectedExceptionRule.expectMessage("What happened?");
        throw new NullPointerException("What happened?");
    }
}
