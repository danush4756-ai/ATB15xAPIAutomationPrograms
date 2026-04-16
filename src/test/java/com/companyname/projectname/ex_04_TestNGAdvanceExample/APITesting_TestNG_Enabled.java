package com.companyname.projectname.ex_04_TestNGAdvanceExample;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting_TestNG_Enabled {

    @Test
    public void test01() {
        Assert.assertTrue(false);
    }
    @Test(enabled = false)//This TC will be skipped while running TCs
    public void test02() {
        Assert.assertTrue(true);
    }
    @Test
    public void test03() {
        Assert.assertTrue(true);
    }
}