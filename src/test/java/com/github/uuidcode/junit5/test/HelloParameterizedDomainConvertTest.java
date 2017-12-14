package com.github.uuidcode.junit5.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class HelloParameterizedDomainConvertTest {
    private DomainConverter domainConverter = new DomainConverter();

    @BeforeEach
    public void beforeEach() {
        System.out.println("beforeEach");
    }

    @DisplayName("https가 지원되는 도메인으로 변경합니다.")
    @ParameterizedTest(name = "{0} -> {1}")
    @CsvSource({
        "storyfunding.devel.kakao.com, storyfunding.devel.kakao.com",
        "studio.storyfunding.devel.kakao.com, studio-storyfunding.devel.kakao.com",
        "local.studio.storyfunding.devel.kakao.com, local-studio-storyfunding.devel.kakao.com"
    })
    public void test(String httpDomain, String httpsDomain) {
        assertEquals(httpsDomain, this.domainConverter.toHttpsDomain(httpDomain));
    }
}
