package com.example.ui.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class MainPage extends WebPage {

    public SelenideElement accountButton = $("a[href*='savva.genchevskiy']");

}
