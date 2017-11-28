package com.github.uuidcode.junit5.test;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HelloDomainConvertTest {
    private DomainConverter domainConverter = new DomainConverter();

    @Test
    @DisplayName("https가 지원되는 도메인으로 변경합니다.")
    public void test() {
        assertEquals(domainConverter.httpsDomain("storyfunding.devel.kakao.com"),
            "storyfunding.devel.kakao.com");
        assertEquals(domainConverter.httpsDomain("studio.storyfunding.devel.kakao.com"),
            "studio-storyfunding.devel.kakao.com");
        assertEquals(domainConverter.httpsDomain("local.studio.storyfunding.devel.kakao.com"),
            "local-studio-storyfunding.devel.kakao.com");
    }
}
