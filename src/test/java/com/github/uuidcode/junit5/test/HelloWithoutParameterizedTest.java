package com.github.uuidcode.junit5.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class HelloWithoutParameterizedTest {
    private Network network = new Network();

    @Test
    public void test() {
        assertTrue(this.network.isPrivateNetwork("192.168.1.12"));
        assertTrue(this.network.isPrivateNetwork("10.20.11.127"));
        assertTrue(this.network.isPrivateNetwork("172.16.4.3"));
        assertFalse(this.network.isPrivateNetwork("172.32.4.3"));
        assertFalse(this.network.isPrivateNetwork("191.1.2.3"));
    }
}
