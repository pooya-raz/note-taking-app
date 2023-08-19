package org.maikini.test;

import org.maikini.test.annotation.BeforeEach;
import org.maikini.test.annotation.Test;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.Logger.Level.ERROR;
import static java.lang.System.Logger.Level.INFO;

public class TestRunner {

    private static final System.Logger logger = System.getLogger(TestRunner.class.getName());

    private static final List<Object> classesToTest = List.of(new NoteServiceTest());

    private TestRunner() {}

    public static void main(String[] args) {
        classesToTest.forEach(TestRunner::runTest);
    }

    private static void runTest(Object testClass) {
        logger.log(INFO, "Running tests for class: " + testClass.getClass().getName());
        final var beforeEachMethod = getBeforeEachMethod(testClass);
        runTestMethods(testClass, beforeEachMethod);
    }

    private static Method getBeforeEachMethod(Object testClass) {
        return Arrays.stream(testClass.getClass().getMethods())
                .filter(method -> method.isAnnotationPresent(BeforeEach.class))
                .findFirst()
                .orElse(null);
    }

    private static void runTestMethods(Object testClass, Method beforeEachMethod) {
        final var methods = testClass.getClass().getMethods();
        for (var method : methods) {
            if (method.isAnnotationPresent(Test.class)) {
                try {
                    if (beforeEachMethod != null) {
                        beforeEachMethod.invoke(testClass);
                    }
                    logger.log(INFO, "Running test: " + method.getName());
                    method.invoke(testClass);
                } catch (Exception e) {
                    logger.log(ERROR, "Error running test: " + method.getName() + " " + e.getMessage());
                }
            }
        }
    }
}
