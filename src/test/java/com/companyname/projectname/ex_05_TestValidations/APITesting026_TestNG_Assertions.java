package com.companyname.projectname.ex_05_TestValidations;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class APITesting026_TestNG_Assertions {

    @Test
    public void test_hardAssertExample() {
        System.out.println("Start of the program");
        Assert.assertEquals("pramod", "Pramod");
        System.out.println("End of the program");/*As we are using hard assertion and as it gives
         false in the last line, this line will not be executed.*/
    }
        @Test
        public void test_softAssertExample() {
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertEquals("pramod","Pramod");
            System.out.println("End of program");
            softAssert.assertAll(); //Here this line is executed because we are using soft assertion.
    }
}