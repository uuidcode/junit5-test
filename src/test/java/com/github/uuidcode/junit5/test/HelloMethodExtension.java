package com.github.uuidcode.junit5.test;

import java.util.Optional;

import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class HelloMethodExtension implements BeforeEachCallback {
    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        Optional<Object> testInstance = context.getTestInstance();
        testInstance.ifPresent(object -> System.out.println(object.getClass()));
        System.out.println("HelloExtension beforeEach");
    }
}