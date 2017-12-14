package com.github.uuidcode.junit5.test;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class HelloDomainConvertTest {
    private DomainConverter domainConverter = new DomainConverter();

    @Test
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
                assertEquals(httpsDomain, this.domainConverter.toHttpsDomain(httpDomain));
            });
    }
}
