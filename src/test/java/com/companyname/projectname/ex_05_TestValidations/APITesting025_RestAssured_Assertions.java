package com.companyname.projectname.ex_05_TestValidations;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class APITesting025_RestAssured_Assertions {
    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
    String request_payload;
    @Test
    public  void test_createBooking_POST() {
        // payload
        // given - setting up the body, url, base path, uri
        // when  - making the req
        // then - extraction
         request_payload = "{\n" +
                "        \"firstname\": \"Darsh\",\n" +
                "        \"lastname\": \"ts\",\n" +
                "        \"totalprice\": 3000,\n" +
                "        \"depositpaid\": true,\n" +
                "        \"bookingdates\": {\n" +
                "            \"checkin\": \"2025-07-22\",\n" +
                "            \"checkout\": \"2025-07-27\"\n" +
                "        },\n" +
                "        \"additionalneeds\": \"Breakfast\"\n" +
                "    }";
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        // header information
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(request_payload);
        response = requestSpecification.when().post();
        // Get Validate response to perform validation
        validatableResponse = response.then().log().all();//Logging means printing.
        //     // Rest Assured. Assertions
        validatableResponse.statusCode(200);
        validatableResponse.body("bookingid",Matchers.notNullValue());
        validatableResponse.body("booking.lastname",Matchers.equalTo("ts"));
        validatableResponse.body("booking.firstname",Matchers.equalTo("Darsh"));
        validatableResponse.body("booking.depositpaid",Matchers.equalTo(true));
        //        validatableResponse.body("booking.bookingdates.checkin",Matchers.equalTo("2018-01-01));
    }
}