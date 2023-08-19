package org.maikini.test.testrunner;

import org.maikini.test.NoteServiceTest;

import java.lang.reflect.Method;
import java.util.Arrays;

import static java.lang.System.Logger.Level.ERROR;
import static java.lang.System.Logger.Level.INFO;

public class TestRunner {

    private static final System.Logger logger = System.getLogger(TestRunner.class.getName());

    private TestRunner() {}

    public static void runTests() {
        final var noteServiceTest = new NoteServiceTest();
        logger.log(
                INFO, "Running tests for class: " + noteServiceTest.getClass().getName());
        final var beforeEachMethod = getBeforeEachMethod(noteServiceTest);
        runTestMethods(noteServiceTest, beforeEachMethod);
        logger.log(
                INFO, "Tests completed for class: " + noteServiceTest.getClass().getName());
    }

    private static Method getBeforeEachMethod(NoteServiceTest noteServiceTest) {
        return Arrays.stream(noteServiceTest.getClass().getMethods())
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
