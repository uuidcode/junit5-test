package com.github.uuidcode.junit5.test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class HelloJUnit4ParameterizedTest {
    private String ip;
    private boolean expected;

    @Parameters(name = "{0} is {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
            { "192.168.1.12", true },
            { "10.20.11.127", true },
            { "172.16.4.3", true },
            { "172.32.4.3", false },
            { "191.1.2.3", false }
        });
    }

    public HelloJUnit4ParameterizedTest(String ip, boolean expected) {
        this.ip = ip;
        this.expected = expected;
    }

    @Test
    public void test() {
        assertEquals(this.expected, new Network().isPrivateNetwork(this.ip));
    }
}
