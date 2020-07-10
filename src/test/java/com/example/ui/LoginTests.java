package com.example.ui;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.junit5.TextReportExtension;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.example.ui.drivers.ChromeDriverProvider;
import com.example.ui.pages.LoginPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


@Tag("ui")
@ExtendWith(TextReportExtension.class)
public class LoginTests {


    public static LoginPage loginPage;


    @BeforeAll
    public static void setup(){
        Configuration.baseUrl = "https://react-redux.realworld.io";
        Configuration.headless = true;
        //Configuration.browser = ChromeDriverProvider.class.getName();
        //Configuration.browser = "com.example.ui.drivers.ChromeDriverProvider";
        //Configuration.remote = "http://127.0.0.1:4444/wd/hub";
        loginPage = new LoginPage();
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }


    @BeforeEach
    public void setupTest(){
        open();
        clearBrowserCookies();
        loginPage.open();
    }

    @AfterAll
    public static void cleanUp(){
        SelenideLogger.removeListener("AllureSelenide");
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "AUTH_PASSWORD", matches = "[A-Z]{1}+\\.+[a-z0-9]{3,15}")
    public void shouldLoginWithEmailAndPassword(){
        loginPage.loginWith("savva.genchevskiy@gmail.com", System.getenv("AUTH_PASSWORD"))
                .accountButton.shouldBe(visible)
                .shouldHave(text("savva.genchevskiy"));

    }


    @Test
    public void shouldThrowErrorWhilenvalidLogin(){
        loginPage.typeLogin("savva.genchevskiy@gmail.com")
                .typePassword("test");
        loginPage.passwordField.pressEnter();
        loginPage.errorMessage.shouldBe(visible).shouldHave(text("email or password is invalid"));
    }
}
