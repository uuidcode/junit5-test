package com.github.uuidcode.junit5.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class HelloParameterizedTest {
    private Network network = new Network();

    @BeforeEach
    public void beforeEach() {
        System.out.println("beforeEach");
    }

    @DisplayName("사설IP 입니다.")
    @ParameterizedTest(name = "{0} is true")
    @ValueSource(strings = { "192.168.1.12", "10.20.11.127", "172.16.4.3" })
    @Tag("fast")
    public void isPrivateNetworkTest(String ip) {
        assertTrue(this.network.isPrivateNetwork(ip));
    }

    @DisplayName("사설IP가 아닙니다.")
    @ParameterizedTest(name = "{0} is false")
    @ValueSource(strings = { "172.32.4.3", "191.1.2.3" })
    @Tag("slow")
    public void isPublicNetworkTest(String ip) {
        assertFalse(this.network.isPrivateNetwork(ip));
    }
}
