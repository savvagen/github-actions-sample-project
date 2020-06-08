package com.example.api.services;

import com.example.api.models.Pet;
import com.example.api.models.ResponseCode;
import com.example.api.models.User;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import retrofit2.Call;
import retrofit2.http.*;

public interface PetService {

    @Step("Get Pet")
    @Description("Should Get Pet from store")
    @Headers({
            "accept: application/json",
            "Content-Type: application/json"
    })
    @GET("/v2/pet/{petId}")
    Call<Pet> getPet(@Path("petId") long id);

    @Step("Create Pet")
    @Description("Should Create Pet in pet store")
    @Headers({
            "accept: application/json",
            "Content-Type: application/json"
    })
    @POST("/v2/pet")
    Call<Pet> createPet(@Body Pet user);
}
