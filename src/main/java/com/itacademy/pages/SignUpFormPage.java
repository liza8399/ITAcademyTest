package com.itacademy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpFormPage {

    private WebDriver driver;

    @FindBy(id = "u_2_4_yS")
    private WebElement sex;

    public SignUpFormPage(WebDriver driver) {
        this.driver = driver;
    }

    public void typeFirstName(String firstName) {
        driver.findElement(By.name("firstname")).sendKeys(firstName);
    }

    public void typeLastName(String lastName) {
        driver.findElement(By.name("lastname")).sendKeys(lastName);
    }

    public void typeEmail(String email) {
        driver.findElement(By.name("reg_email__")).sendKeys(email);
    }

    public void sexChoice() {
        driver.findElement(By.id("u_2_4_yS")).click();
    }
}
