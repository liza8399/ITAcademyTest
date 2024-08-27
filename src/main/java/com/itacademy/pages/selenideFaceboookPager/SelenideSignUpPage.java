package com.itacademy.pages.selenideFaceboookPager;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.*;

public class SelenideSignUpPage {

    private WebDriver driver;

    SelenideElement femaleRdBtn = $x("//*[@class='_58mt']");

    public void typeFirstName(String firstName) {
        $(By.name("firstname")).setValue(firstName);
    }

    public void typeLastName(String lastName) {
        $(By.name("lastname")).setValue(lastName);
    }

    public void typeEmail(String email) {
        $(By.name("reg_email__")).setValue(email);
    }

    public void sexChoice(){
        femaleRdBtn.click();
    }
}
