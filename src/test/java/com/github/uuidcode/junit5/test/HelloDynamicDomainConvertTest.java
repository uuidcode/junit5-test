package com.github.uuidcode.junit5.test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

public class HelloDynamicDomainConvertTest {
    private DomainConverter domainConverter = new DomainConverter();

    @TestFactory
    @DisplayName("https가 지원되는 도메인으로 변경합니다.")
    public Stream<DynamicTest> test() {
        Map<String, String> domainMap = new HashMap<String, String>() {{
            this.put("storyfunding.devel.kakao.com", "storyfunding.devel.kakao.com");
            this.put("studio.storyfunding.devel.kakao.com", "studio-storyfunding.devel.kakao.com");
            this.put("local.studio.storyfunding.devel.kakao.com", "local-studio-storyfunding.devel.kakao.com");
        }};

        return domainMap.entrySet()
            .stream()
            .map(entry -> {
                String httpDomain = entry.getKey();
                String httpsDomain = entry.getValue();

                return dynamicTest(httpDomain + " -> " + httpsDomain,
                    () -> assertEquals(this.domainConverter.httpsDomain(httpDomain), httpsDomain));
            });
    }
}
