package com.github.uuidcode.junit5.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class HelloParameterizedTest {
    public boolean isPrivateNetwork(String ip) {
        if (ip.startsWith("192.168.")
            || ip.startsWith("10.")) {
            return true;
        }

        if (ip.startsWith("172.")) {
            String[] ipValue = ip.split("\\.");
            int secondNumber = Integer.parseInt(ipValue[1]);
            return 16 <= secondNumber && secondNumber <= 31;
        }

        return false;
    }

    @DisplayName("사설IP 주소인가?")
    @ParameterizedTest
    @ValueSource(strings = { "192.168.1.12", "10.20.11.127", "172.16.4.3" })
    @Tag("fast")
    public void isPrivateNetworkTest(String ip) {
        System.out.println("fast");
        assertThat(isPrivateNetwork(ip)).isTrue();
    }

    @DisplayName("공인IP 주소인가?")
    @ParameterizedTest
    @ValueSource(strings = { "172.32.4.3", "191.1.2.3" })
    @Tag("slow")
    public void isPublicNetworkTest(String ip) {
        System.out.println("slow");
        assertThat(isPrivateNetwork(ip)).isFalse();
    }
}
