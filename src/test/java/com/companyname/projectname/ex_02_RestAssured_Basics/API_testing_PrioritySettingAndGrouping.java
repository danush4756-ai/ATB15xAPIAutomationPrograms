package com.companyname.projectname.ex_02_RestAssured_Basics;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class API_testing_PrioritySettingAndGrouping {
    @Test(priority = 3, groups = {"pincode","positive"})/*We can group according to our needs but should
    follow industry practice while doing it in reality. Like, we may group regression testing, smoke
    testing, etc.*/
    public void test_Positive_tc1(){
        String pincode = "110048";
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/"+pincode)
                .when()
                .get()
                .then()
                .log().all().statusCode(200);
    }
    @Test(priority = 1, groups = {"pincode","negative"}) //if Priority is -n it will have the highest priority.
    public void test_Negative_tc1(){
        String pincode = "@";
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/"+pincode)
                .when()
                .get()
                .then()
                .log().all().statusCode(200);
    }
    @Test (groups = {"pincode","negative"})
    public void test_Negative_tc2(){
        String pincode = " ";
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/"+pincode)
                .when()
                .get()
                .then()
                .log().all().statusCode(200);
    }
}
