package com.github.uuidcode.junit5.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class HelloParameterizedWithCsvTest {
    private Network network = new Network();

    @DisplayName("사설IP 주소인가?")
    @ParameterizedTest(name = "{0} is {1}")
    @CsvSource({
        "192.168.1.12, true",
        "10.20.11.127, true",
        "172.16.4.3, true",
        "172.32.4.3, false",
        "191.1.2.3, false"
    })
    public void test(String ip, boolean expected) {
        assertEquals(expected, this.network.isPrivateNetwork(ip));
    }
}
