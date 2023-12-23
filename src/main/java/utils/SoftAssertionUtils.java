package utils;

import core.BaseTest;
import org.testng.asserts.SoftAssert;

public class SoftAssertionUtils extends BaseTest {

    private SoftAssert softAssert;

    public SoftAssertionUtils() {
        softAssert = new SoftAssert();
    }

    public void assertEquals(Object actual, Object expected, String message) {
        try {
            softAssert.assertEquals(actual, expected, message);
        } catch (AssertionError e) {
            handleAssertionFailure(message, e);
        }
    }

    public void assertTrue(boolean condition, String message) {
        try {
            softAssert.assertTrue(condition, message);
        } catch (AssertionError e) {
            handleAssertionFailure(message, e);
        }
    }

    public void assertFalse(boolean condition, String message) {
        try {
            softAssert.assertFalse(condition, message);
        } catch (AssertionError e) {
            handleAssertionFailure(message, e);
        }
    }

    public void assertAll() {
        try {
            softAssert.assertAll();
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
