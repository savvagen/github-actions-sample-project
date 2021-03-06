package com.example.api.services;

import com.example.api.models.ResponseCode;
import com.example.api.models.User;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import retrofit2.Call;
import retrofit2.http.*;

public interface UserService {

    @Step("Create User")
    @Description("Should Create user in pet store")
    @Headers({
            "accept: application/json",
            "Content-Type: application/json"
    })
    @POST("/v2/user")
    Call<ResponseCode> createUser(@Body User user);

}
