package com.itacademy.pages.facebookPages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.codeborne.selenide.Selenide.*;

public class SelenideHomePage {

    private WebDriver driver;

    SelenideElement createNewAccountBtn = $x( "//*[@data-testid ='open-registration-form-button']");
    SelenideElement allowAllCookiesBtn = $x("(//*[text() = 'Allow all cookies'])[2]");
    SelenideElement forgotPasswordBtn = $x("//*[@class ='_6ltj']");
    SelenideElement emailFieldInput = $(By.id("email"));
    SelenideElement passwordFieldInput = $(By.id("pass"));
    SelenideElement loginBtn = $x("//*[@data-testid='royal_login_button']");


    public void open(){
        driver.get("https://www.facebook.com/");
    }
    public void clickCookies(){
        allowAllCookiesBtn.click();
    }

    public SignUpFormPage clickCreateNewAccountBtn(){
        createNewAccountBtn.click();
        return new SignUpFormPage(driver);
    }

    public String getCreateNewAccountBtnText(){
        return createNewAccountBtn.getText();
    }

    public ForgotPasswordPage clickForgotPasswordBtn(){
        forgotPasswordBtn.click();
        return new ForgotPasswordPage(driver);
    }

    public void emailInput (String emailText){
        emailFieldInput.sendKeys(emailText);
    }

    public void passwordInput (String passwordText){
        passwordFieldInput.sendKeys(passwordText);
    }

    public FailedLogin clickLogInBtn(){
        loginBtn.click();
        return new FailedLogin(driver);
    }
}
