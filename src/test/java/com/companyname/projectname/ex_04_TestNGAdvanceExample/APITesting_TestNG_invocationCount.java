package com.companyname.projectname.ex_04_TestNGAdvanceExample;

import org.testng.annotations.Test;

public class APITesting_TestNG_invocationCount {

    @Test(invocationCount = 2)//We can set how many times the test should run.
    public void test01(){
        System.out.println("Hi");
    }

    @Test(invocationCount = 3)
    public void test02(){
        System.out.println("Bye");
    }
}