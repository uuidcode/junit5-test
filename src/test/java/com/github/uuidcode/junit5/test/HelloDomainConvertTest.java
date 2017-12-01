package com.github.uuidcode.junit5.test;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HelloDomainConvertTest {
    private DomainConverter domainConverter = new DomainConverter();

    @Test
    @DisplayName("https가 지원되는 도메인으로 변경합니다.")
    public void test() {
        Map<String, String> domainMap = new HashMap<String, String>() {{
            this.put("storyfunding.devel.kakao.com", "storyfunding.devel.kakao.com");
            this.put("studio.storyfunding.devel.kakao.com", "studio-storyfunding.devel.kakao.com");
            this.put("local.studio.storyfunding.devel.kakao.com", "local-studio-storyfunding.devel.kakao.com");
        }};

        domainMap.entrySet()
            .stream()
            .forEach(entry -> {
                String httpDomain = entry.getKey();
                String httpsDomain = entry.getValue();
                assertEquals(httpsDomain, this.domainConverter.httpsDomain(httpDomain));
            });
    }
}
