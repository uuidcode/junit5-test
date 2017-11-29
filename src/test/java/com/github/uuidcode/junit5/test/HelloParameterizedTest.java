package com.github.uuidcode.junit5.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class HelloParameterizedTest {
    private Network network = new Network();

    @DisplayName("사설IP 주소인가?")
    @ParameterizedTest(name = "{0} is true")
    @ValueSource(strings = { "192.168.1.12", "10.20.11.127", "172.16.4.3" })
    @Tag("fast")
    public void isPrivateNetworkTest(String ip) {
        System.out.println("fast");
        assertThat(this.network.isPrivateNetwork(ip)).isTrue();
    }

    @DisplayName("공인IP 주소인가?")
    @ParameterizedTest(name = "{0} is false")
    @ValueSource(strings = { "172.32.4.3", "191.1.2.3" })
    @Tag("slow")
    public void isPublicNetworkTest(String ip) {
        System.out.println("slow");
        assertThat(this.network.isPrivateNetwork(ip)).isFalse();
    }

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
        assertThat(this.network.isPrivateNetwork(ip)).isEqualTo(expected);
    }
}
