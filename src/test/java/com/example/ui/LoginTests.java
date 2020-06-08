package com.example.ui;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.example.ui.drivers.ChromeDriverProvider;
import com.example.ui.pages.LoginPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;


@Tag("ui")
public class LoginTests {


    @BeforeAll
    public static void setup(){
        Configuration.baseUrl = "https://react-redux.realworld.io";
        Configuration.headless = true;
        //Configuration.browser = ChromeDriverProvider.class.getName();
        //Configuration.browser = "com.example.ui.drivers.ChromeDriverProvider";
        //Configuration.remote = "http://127.0.0.1:4444/wd/hub";
    }


    @Test
    public void shouldLogin(){
        var loginPage = new LoginPage().open()
                .typeLogin("savva.genchevskiy@gmail.com")
                .typePassword("test");
        loginPage.passwordField.pressEnter();
        loginPage.errorMessage.shouldBe(Condition.visible).shouldHave(Condition.text("email or password is invalid"));
    }
}
