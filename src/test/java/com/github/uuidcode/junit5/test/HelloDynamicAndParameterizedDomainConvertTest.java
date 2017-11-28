package com.github.uuidcode.junit5.test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class HelloDynamicAndParameterizedDomainConvertTest {
    private DomainConverter domainConverter = new DomainConverter();

    @TestFactory
    @DisplayName("https가 지원되는 도메인으로 변경합니다.")
    @ParameterizedTest
    @CsvSource({"storyfunding.devel.kakao.com, storyfunding.devel.kakao.com"})
    public Stream<DynamicTest> test(String before, String after) {
        return Stream.of(dynamicTest(before + "->" + after,
                    () -> assertEquals(this.domainConverter.httpsDomain(before), after)));
    }
}
