package com.itacademy.pages.facebookPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FailedLogin {

    private WebDriver driver;

    @FindBy(xpath = "//div[contains(@class, 'fsl') and contains(@class, 'fwb') and contains(@class, 'fcb')]")
    private WebElement failedLoginMessage;

    public FailedLogin(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String failedLogInPageMessage(){
        return failedLoginMessage.getText();
    }
}
