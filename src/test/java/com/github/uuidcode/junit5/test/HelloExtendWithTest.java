package com.github.uuidcode.junit5.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

@ExtendWith(MockitoExtension.class)
public class HelloExtendWithTest {
    @BeforeEach
    public void beforeEach(@Mock DomainConverter domainConverter) {
        when(domainConverter.httpsDomain(any())).thenReturn("hello");
    }

    @Test
    public void test(@Mock DomainConverter domainConverter) {
        assertEquals("hello", domainConverter.httpsDomain("test"));
    }
}
