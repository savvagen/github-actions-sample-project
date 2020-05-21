package com.example.api;

import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class BaseApiTest {


    @BeforeAll
    public static void setUpApiTests(){
        RestAssured.baseURI = "https://petstore.swagger.io/v2";

    }

    @AfterAll
    public static void tearDownApiTests(){

    }

}
