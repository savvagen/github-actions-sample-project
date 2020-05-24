package com.example.api;

import com.example.api.services.UserService;
import com.github.javafaker.Faker;
import io.qameta.allure.okhttp3.AllureOkHttp3;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.junit.jupiter.api.BeforeAll;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.Locale;

import static okhttp3.logging.HttpLoggingInterceptor.*;

public class BaseApiTest {

    public static Retrofit retrofit;
    public static UserService userService;
    public static Faker faker;

    public static OkHttpClient.Builder httpClient;


    @BeforeAll
    public static void setUp(){
        faker = new Faker(new Locale("en_us"));

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor().setLevel(Level.BODY);
        AllureOkHttp3 allure = new AllureOkHttp3();

        httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);
        httpClient.addInterceptor(allure);

        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://petstore.swagger.io/")
                .client(httpClient.build())
                .build();
        userService = retrofit.create(UserService.class);
    }

}
