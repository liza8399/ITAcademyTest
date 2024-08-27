package com.itacademy.pages.selenideFaceboookPager;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.codeborne.selenide.Selenide.*;

public class SelenideForgotPswPage {

    private WebDriver driver;

    SelenideElement forgotPasswordTitle = $x("//*[@class='uiHeaderTitle']");

    public String forgotPasswordPageText() {
        return forgotPasswordTitle.getText();
    }
}

