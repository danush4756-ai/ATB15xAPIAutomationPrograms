package com.companyname.projectname.ex_03_RestAssured_TestNG.DELETE;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting_DELETE_NONBddStyle {

    //  Delete
    // Pre - Req.
    // token, booking id

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;


    @Test
    public void test_put_non_bdd() {

        String token = "1ea8a6341afa93d";
        String bookingid = "248";

        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/" + bookingid);

        r.contentType(ContentType.JSON);
        r.cookie("token", token);

        response = r.when().log().all().delete();

        vr = response.then().log().all();
        vr.statusCode(201);

    }

}