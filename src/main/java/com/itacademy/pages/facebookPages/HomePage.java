package com.itacademy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;

    @FindBy(xpath = "//*[@data-testid ='open-registration-form-button']")
    private WebElement createNewAccountBtn;

    @FindBy(xpath = "(//*[text() = 'Allow all cookies'])[2]")
    private WebElement allowAllCookiesBtn;

    @FindBy(xpath = "//*[@class ='_6ltj']")
    private WebElement forgotPasswordBtn;

    @FindBy(id = "email")
    private WebElement emailFieldInput;

    @FindBy(id = "pass")
    private WebElement passwordFieldInput;

    @FindBy(xpath = "//*[@data-testid='royal_login_button']")
    private WebElement loginBtn;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

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
