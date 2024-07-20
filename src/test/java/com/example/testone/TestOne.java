package com.example.testone;

import io.restassured.RestAssured;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TestOne {

    @Test
    public void testGetRequest() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        given().
                when().
                get("/posts/1").
                then().
                statusCode(200).
                body("userId", equalTo(1)).
                body("id", equalTo(1)).
                body("title", notNullValue()).
                body("body", notNullValue()).log().all();
    }
}
