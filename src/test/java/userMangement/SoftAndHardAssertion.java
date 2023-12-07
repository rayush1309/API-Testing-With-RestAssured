package userMangement;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAndHardAssertion {

    @Test
    public void HardAssertion(){
        Assert.assertTrue(true);
        System.out.println("Pass");
        Assert.assertTrue(false);
        System.out.println("Hard Assertion fail");
    }
    @Test
    public void SoftAssertion(){
        SoftAssert SoftAssertion = new SoftAssert();
        SoftAssertion.assertTrue(true);
        SoftAssertion.assertTrue(false);
        SoftAssertion.assertTrue(true);
        SoftAssertion.assertTrue(true);
        SoftAssertion.assertTrue(true);
        SoftAssertion.assertTrue(true);
        SoftAssertion.assertAll();
        System.out.println("soft assertion exeduted ");

    }

}
