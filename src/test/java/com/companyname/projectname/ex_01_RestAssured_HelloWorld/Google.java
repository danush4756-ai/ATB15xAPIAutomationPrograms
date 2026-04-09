package com.companyname.projectname.ex_01_RestAssured_HelloWorld;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class Google {

    @Test
    public void test_RA(){
        RestAssured
                .given()
                 .baseUri("https://google.com")
                 .log()//print details of the request
                 .all()//Print EVERYTHING
                .when()
                 .get()
                .then()
                 .statusCode(200)
                 .log().all();//Print complete details
    }
}
