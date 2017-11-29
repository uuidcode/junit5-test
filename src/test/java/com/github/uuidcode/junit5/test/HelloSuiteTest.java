package com.github.uuidcode.junit5.test;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({
    HelloStackTest.class,
    HelloNestedStackTest.class
})
public class HelloSuiteTest {
}
