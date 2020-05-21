package com.example.services;

import com.example.models.ResponseCode;
import com.example.models.User;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

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
