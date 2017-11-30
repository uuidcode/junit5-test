package com.github.uuidcode.junit5.test;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class HelloJUni4AndJUnit5 {
    @Test
    @DisplayName("안녕하세요")
    public void junit4() {
        System.out.println("OK");
    }
}
