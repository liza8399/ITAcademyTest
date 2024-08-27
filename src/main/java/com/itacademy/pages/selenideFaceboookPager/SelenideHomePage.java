package com.itacademy.pages.selenideFaceboookPager;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.itacademy.pages.facebookPages.FailedLogin;
import com.itacademy.pages.facebookPages.ForgotPasswordPage;
import com.itacademy.pages.facebookPages.SignUpFormPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
        Selenide.open("https://www.facebook.com/");
    }

    public void clickCookies(){
        allowAllCookiesBtn.click();
    }

    public SelenideSignUpPage clickCreateNewAccountBtn(){
        createNewAccountBtn.click();
        return new SelenideSignUpPage();
    }

    public String getCreateNewAccountBtnText(){
        return createNewAccountBtn.getText();
    }

    public SelenideForgotPswPage clickForgotPasswordBtn(){
        forgotPasswordBtn.click();
        return new SelenideForgotPswPage();
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
