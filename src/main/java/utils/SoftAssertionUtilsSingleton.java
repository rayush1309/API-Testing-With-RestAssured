package utils;

import org.testng.asserts.SoftAssert;

public class SoftAssertionUtilsSingleton {

    private static  SoftAssertionUtilsSingleton softAssertInstance; // Corrected the class name
    private SoftAssert softAssert;

    // Corrected the constructor to be private
    private SoftAssertionUtilsSingleton() {
        softAssert = new SoftAssert();
    }

    public static SoftAssertionUtilsSingleton getInstance() {
        if (softAssertInstance == null) {
            softAssertInstance = new SoftAssertionUtilsSingleton();
        }
        return softAssertInstance;
    }

    public void assertEquals(Object actual, Object expected, String message) {
        try {
            getInstance().softAssert.assertEquals(actual, expected, message);
        } catch (AssertionError e) {
            getInstance().softAssert.fail(message);
        }
    }

    public void assertTrue(boolean condition, String message) {
        try {
            getInstance().softAssert.assertTrue(condition, message);
        } catch (AssertionError e) {
            getInstance().softAssert.fail(message);
        }
    }

    public void assertFalse(boolean condition, String message) {
        try {
            getInstance().softAssert.assertFalse(condition, message);
        } catch (AssertionError e) {
            handleAssertionFailure(message, e);
        }
    }

    public void assertNotEquals(Object actual, Object expected, String message) {
        try {
            getInstance().softAssert.assertNotEquals(actual, expected, message);
        } catch (AssertionError e) {
            getInstance().softAssert.fail(message);
        }
    }

    public void assertAll() {
        try {
            getInstance().softAssert.assertAll();
        } catch (AssertionError e) {
            handleAssertionFailure("Soft assertions failed during assertAll", e);
        }
    }

    private void handleAssertionFailure(String message, AssertionError e) {
        // You can customize how you want to handle the failure, e.g., logging, reporting, etc.
        System.out.println("Assertion failed: " + message);
        e.printStackTrace();
    }
}
