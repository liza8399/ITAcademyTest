package com.itacademy.pages.facebookPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {

    private WebDriver driver;

    @FindBy(xpath = "//*[@class='uiHeaderTitle']")
    private WebElement forgotPasswordTitle;

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String ForgotPasswordPageText() {
        return forgotPasswordTitle.getText();
    }
}
