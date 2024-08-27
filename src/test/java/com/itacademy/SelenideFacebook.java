package com.itacademy;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.itacademy.pages.selenideFaceboookPager.SelenideForgotPswPage;
import com.itacademy.pages.selenideFaceboookPager.SelenideHomePage;
import com.itacademy.pages.selenideFaceboookPager.SelenideSignUpPage;
import com.itacademy.utils.Waiters;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static org.testng.Assert.assertEquals;

public class SelenideFacebook {

    @Test
    public void firstTest() {
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
        SelenideHomePage selenideHomePage = new SelenideHomePage();
        selenideHomePage.open();
        selenideHomePage.emailInput("123");
        selenideHomePage.passwordInput("456");
        selenideHomePage.clickLogInBtn();
        $x("//*[@class='_9ay7']").shouldHave(text("Введенный вами электронный адрес или номер мобильного телефона не связан ни с одним аккаунтом. Найдите свой аккаунт и войдите в систему."));
        Waiters.wait(3000);
    }

    @Test
    public void secondTest() {
        SelenideHomePage selenideHomePage = new SelenideHomePage();
        selenideHomePage.open();
        String homePageWindow = Selenide.webdriver().object().getWindowHandle();
        SelenideForgotPswPage selenideForgotPswPage = selenideHomePage.clickForgotPasswordBtn();
        for (String windowString: webdriver().object().getWindowHandles()){
            if(!windowString.equals(homePageWindow)){
                switchTo().window(windowString);
            }
        }
        String forgotPswPageText = selenideForgotPswPage.forgotPasswordPageText();
        forgotPswPageText.equals("Поиск аккаунта");
    }

    @Test
    public void thirdTest() {
        SelenideHomePage selenideHomePage = new SelenideHomePage();
        selenideHomePage.open();
        SelenideSignUpPage selenideSignUpPage = selenideHomePage.clickCreateNewAccountBtn();
        selenideSignUpPage.typeFirstName("123");
        selenideSignUpPage.typeLastName("456");
        selenideSignUpPage.typeEmail("123@gmail.com");
        selenideSignUpPage.sexChoice();
        String testScreen = screenshot("testsuccess");
    }
}
