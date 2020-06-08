package com.example.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends WebPage {

    public SelenideElement loginFiled = $("input[type='email']");
    public SelenideElement passwordField = $("input[type='password']");
    public SelenideElement errorMessage = $(".error-messages > li");

    public LoginPage(){
        this.url = "/#/login";
        this.title = "";
    }


    @Step
    public LoginPage open(){
        return Selenide.open(this.url, this.getClass());
    }

    @Step
    public LoginPage typeLogin(String login){
        loginFiled.shouldBe(visible).val(login);
        return this;
    }

    @Step
    public LoginPage typePassword(String password){
        passwordField.shouldBe(visible).val(password);
        return this;
    }



}
