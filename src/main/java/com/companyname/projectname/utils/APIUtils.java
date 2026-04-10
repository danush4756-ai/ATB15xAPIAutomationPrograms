package com.companyname.projectname.utils;

import io.restassured.RestAssured;

public class APIUtils {
    public static void validatePincodeAndStstusCode(String pincode, int expectedStatusCode) {

        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode)
                .when()
                .get()
                .then()
                .log().all()
                .statusCode(expectedStatusCode);
    }
}
