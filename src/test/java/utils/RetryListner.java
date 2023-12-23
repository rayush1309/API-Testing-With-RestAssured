package utils;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class RetryListner implements IAnnotationTransformer {

        @Override
        public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
            // Correct implementation with a class that implements IRetryAnalyzer
            annotation.setRetryAnalyzer(FailedRetryListener.class);  // Replace RetryAnalyzer.class with your actual implementation
        }
    }



