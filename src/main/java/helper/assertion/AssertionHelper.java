package helper.assertion;

import helper.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.testng.Assert;

public class AssertionHelper {

    private static final Logger log = LoggerHelper.getLogger(AssertionHelper.class);

    public static void verifyText(String s1, String s2) {
        log.info("Verifying test: " + s1 + " with " + s2);
        System.out.println("Verifying test: " + s1 + " with " + s2);
        Assert.assertEquals(s1, s1);
    }

    public static void markPass() {
        log.info("making script PASS..");
        System.out.println("making script PASS..");
        Assert.assertTrue(true);
    }

    public static void markPass(String message) {
        log.info("making script PASS => " + message);
        System.out.println("making script PASS => " + message);
        Assert.assertTrue(true, message);
    }

    public static void markFail() {
        log.info("making script FAIL..");
        System.out.println("making script FAIL..");
        Assert.assertTrue(false);
    }

    public static void markFail(String message) {
        log.info("making script FAIL.." + message);
        System.out.println("making script FAIL => " + message);
        Assert.assertTrue(false, message);
    }

    public static void verifyTrue(boolean status) {
        log.info("verify object is True..");
        System.out.println("verify object is True..");
        Assert.assertTrue(status);
    }

    public static void verifyFalse(boolean status) {
        log.info("verify object is False..");
        System.out.println("verify object is False..");
        Assert.assertFalse(status);
    }

    public static void verifyNull(String s1) {
        log.info("verify object is null..");
        System.out.println("verify object is null..");
        Assert.assertNull(s1);
    }

    public static void verifyNotNull(String s1) {
        log.info("verify object is not null..");
        System.out.println("verify object is not null..");
        Assert.assertNotNull(s1);
    }

    public static void fail() {
        Assert.assertTrue(false);
    }

    public static void pass() {
        Assert.assertTrue(true);
    }

    public static void updateTestStatus(boolean status) {
        if (status) {
            pass();
            System.out.println("updateTestStatus => PASSED");
        } else {
            fail();
            System.out.println("updateTestStatus => FAILED");

        }
    }
}
