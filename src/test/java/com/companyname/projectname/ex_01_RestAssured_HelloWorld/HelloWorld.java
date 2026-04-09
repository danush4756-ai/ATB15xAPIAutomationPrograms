package com.companyname.projectname.ex_01_RestAssured_HelloWorld;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class HelloWorld {
@Test
    public void Test_Hello_World () {
//Given-prerequisites
    //When-action
    //Then-validation
    RestAssured
            //Step one - prerequisites
            .given()
            .baseUri("https://restful-booker.herokuapp.com")
             .basePath("/ping")
            //Step two - action
            .when()
             .get()
            //step three - validation
            .then()
             .statusCode(200);
}
}
