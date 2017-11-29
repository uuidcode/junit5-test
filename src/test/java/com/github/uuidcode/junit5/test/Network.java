package com.github.uuidcode.junit5.test;

public class Network {
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
}
