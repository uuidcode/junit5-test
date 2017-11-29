package com.github.uuidcode.junit5.test;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class HelloParameterizedDomainConvertTest {
    private DomainConverter domainConverter = new DomainConverter();

    @DisplayName("https가 지원되는 도메인으로 변경합니다.")
    @ParameterizedTest(name = "{0} -> {1}")
    @CsvSource({
        "storyfunding.devel.kakao.com, storyfunding.devel.kakao.com",
        "studio.storyfunding.devel.kakao.com, studio-storyfunding.devel.kakao.com",
        "local.studio.storyfunding.devel.kakao.com, local-studio-storyfunding.devel.kakao.com"
    })
    public void test(String before, String after) {
        assertEquals(this.domainConverter.httpsDomain(before), after);
    }
}
