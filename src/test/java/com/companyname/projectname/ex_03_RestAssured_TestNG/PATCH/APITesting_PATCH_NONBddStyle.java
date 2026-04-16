package com.companyname.projectname.ex_03_RestAssured_TestNG.PATCH;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting_PATCH_NONBddStyle {
    //  Patch
    // Pre - Req.
    // token, booking id - A

    //    public void get_token(){ }
//    public void get_booking_id(){}
    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Test
    public void test_Patch(){

        String token = "1ea8a6341afa93d";
        String bookingid = "248";

        String payload  = "{\n" +
                "    \"firstname\" : \"Darsh\",\n" +
                "    \"lastname\" : \"Brown\"\n" +
                "}";

        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/"+bookingid);

        r.contentType(ContentType.JSON);
        r.cookie("token",token);
        r.body(payload).log().all();


        response = r.when().log().all().patch();


        vr = response.then().log().all();
        vr.statusCode(200);

    }
}