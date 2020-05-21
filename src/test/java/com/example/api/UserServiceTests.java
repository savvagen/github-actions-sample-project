package com.example.api;

import com.example.models.User;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserServiceTests extends BaseApiTest {


    @Test
    @DisplayName("Should Register User")
    public void  shouldRegisterUser(){
        User user = User.buildUser().withId(0).withUsername("My User")
                .withFirstName("My").withLastName("User")
                .withEmail("test@gmail.com")
                .withPassword("qwert")
                .withUserStatus(1).build();
        RestAssured.given().relaxedHTTPSValidation()
                .filters(new RequestLoggingFilter(), new ResponseLoggingFilter())
                .accept("application/json")
                .contentType("application/json")
                .body(user)
                .when().post("/user").then().assertThat().statusCode(200);
    }


}
