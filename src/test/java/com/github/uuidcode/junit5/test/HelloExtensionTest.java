package com.github.uuidcode.junit5.test;

import java.util.stream.IntStream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.engine.execution.AfterEachMethodAdapter;
import org.junit.jupiter.engine.execution.BeforeEachMethodAdapter;
import org.junit.jupiter.engine.extension.ExtensionRegistry;

@ExtendWith(HelloExtensionTest.class)
public class HelloExtensionTest implements BeforeEachMethodAdapter,
    AfterEachMethodAdapter, BeforeEachCallback, AfterEachCallback, AfterTestExecutionCallback,
    BeforeTestExecutionCallback, BeforeAllCallback, AfterAllCallback, ExecutionCondition {

    static int depth = 0;


    public static void log(String message) {
        IntStream.range(0, depth)
            .forEach(i -> System.out.print("    "));

        System.out.println(message);
    }
    
    @AfterEach
    public void afterEach() {
        depth--;
        log("AfterEach");
    }

    @BeforeEach
    public void beforeEach() {
        depth++;
        log("BeforeEach");
    }

    @AfterAll
    public static void afterAll() {
        depth--;
        log("AfterAll");
    }

    @BeforeAll
    public static void beforeAll() {
        depth++;
        log("BeforeAll");
    }

    @Test
    public void test() {
        depth++;
        log("test");
    }

    @Override
    public void invokeBeforeEachMethod(ExtensionContext context, ExtensionRegistry extensionRegistry) throws Throwable {
        depth++;
        log("BeforeEachMethodAdapter");

    }

    @Override
    public void invokeAfterEachMethod(ExtensionContext context, ExtensionRegistry extensionRegistry) throws Throwable {
        depth--;
        log("AfterEachMethodAdapter");
    }

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        depth++;
        log("BeforeEachCallback");
    }

    @Override
    public void afterEach(ExtensionContext extensionContext) throws Exception {
        depth--;
        log("AfterEachCallback");
    }

    @Override
    public void afterTestExecution(ExtensionContext context) throws Exception {
        depth--;
        log("AfterTestExecutionCallback");
    }

    @Override
    public void beforeTestExecution(ExtensionContext context) throws Exception {
        depth++;
        log("BeforeTestExecutionCallback");
    }

    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        log("BeforeAllCallback");
    }

    @Override
    public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {
        //log("ExecutionCondition**");
        return ConditionEvaluationResult.enabled("test");
    }

    @Override
    public void afterAll(ExtensionContext context) throws Exception {
        depth--;
        log("AfterAllCallback");
    }
}
