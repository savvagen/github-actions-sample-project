package com.example.ui;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;


@Tag("ui")
public class LoginTests {


    @BeforeAll
    public static void setup(){
        Configuration.baseUrl = "https://react-redux.realworld.io";
        //Configuration.headless = true;
        Configuration.remote = "http://127.0.0.1:4444/wd/hub";
    }


    @Test
    public void shouldLogin(){
        open("/#/login");
        $("input[type='email']").setValue("savva.genchevskiy@gmail.com");
        $("input[type='password']").setValue("test").pressEnter();
        $(".error-messages > li").shouldBe(Condition.visible).shouldHave(Condition.text("email or password is invalid"));
    }
}
