package com.example.api.services;

import com.example.api.models.Pet;
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
    Call<Pet> getPet(@Path("petId") Integer id);

}
