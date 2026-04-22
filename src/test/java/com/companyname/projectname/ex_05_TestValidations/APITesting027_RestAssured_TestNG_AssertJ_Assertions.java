package com.companyname.projectname.ex_05_TestValidations;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;
public class APITesting027_RestAssured_TestNG_AssertJ_Assertions {
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    Response response;
    Integer bookingId;
    @Test
    public void test_POST() {
        String payload_POST = "{\n" +
                "    \"firstname\" : \"Pramod\",\n" +
                "    \"lastname\" : \"Dutta\",\n" +
                "    \"totalprice\" : 123,\n" +
                "    \"depositpaid\" : false,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-01-01\",\n" +
                "        \"checkout\" : \"2024-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch\"\n" +
                "}";
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload_POST).log().all();

        response = requestSpecification.when().post();
        // Get Validate response to perform validation
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        //  Extract Response
        // booking ID, firstname, lastname, checkin dates.
        // Extraction
        // Concept #1 - Normal( TestNG or Assertj) IS IMP
        bookingId = response.then().extract().path("bookingid");
        String firstname = response.then().extract().path("booking.firstname");
        String lastname = response.then().extract().path("booking.lastname");
        // Concept #2 - (Jsonpath class) Another mechanism to extract the Keys, value by JSON Path
        JsonPath jp = new JsonPath(response.asString());
        assertThat(jp.getString("booking.firstname")).isEqualTo("Pramod");
        assertThat(jp.getString("booking.lastname")).isEqualTo("Dutta");
        assertThat(jp.getInt("booking.totalprice")).isEqualTo(123);
        assertThat(jp.getBoolean("booking.depositpaid")).isFalse();
        // TestNG - Extract the details of the firstname, bookingId, lastname from Response.
        // TestNG Assertions - 75%
        // SoftAssert vs HardAssert (90%)
        // This means that if any assertion fails,
        // the remaining statements in that test method will not be executed.
        Assert.assertEquals(firstname,"Pramod");
        Assert.assertEquals(lastname,"Dutta");
        Assert.assertNotNull(bookingId);
        //functions
        assertThat(bookingId).isNotZero().isNotNull().isPositive();
        assertThat(bookingId)
                .isNotNull()
                .isBetween(0, 9999);
        assertThat(firstname).isNotBlank().isNotEmpty().isNotNull().isEqualTo("Pramod");
    }
}