package com.itacademy;

import com.itacademy.pages.facebookPages.FailedLogin;
import com.itacademy.pages.facebookPages.ForgotPasswordPage;
import com.itacademy.pages.facebookPages.HomePage;
import com.itacademy.pages.facebookPages.SignUpFormPage;
import com.itacademy.utils.DriverManager;
import com.itacademy.utils.ScreenshotUtils;
import com.itacademy.utils.Waiters;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.module.Configuration;

public class FacebookTest extends BaseTest {

    @Test
    public void signUpTest(){
        DriverManager.getDriver().get("https://www.facebook.com/");
        HomePage homePage = new HomePage(DriverManager.getDriver());
//        homePage.clickCookies();
        Assert.assertEquals(homePage.getCreateNewAccountBtnText(), "Создать новый аккаунт");
        SignUpFormPage signUpFormPage = homePage.clickCreateNewAccountBtn();
        signUpFormPage.typeFirstName("123");
        signUpFormPage.typeLastName("456");
        signUpFormPage.typeEmail("123@gmail.com");
        signUpFormPage.sexChoice();
        ScreenshotUtils.makeScreenshot(DriverManager.getDriver(), "signupForm");
    }

    @Test
    public void forgotPasswordTest(){
        DriverManager.getDriver().get("https://www.facebook.com/");
        String homePageWindow = DriverManager.getDriver().getWindowHandle();
        HomePage homePage = new HomePage(DriverManager.getDriver());
        ForgotPasswordPage forgotPasswordPage = homePage.clickForgotPasswordBtn();
        Waiters.wait(3000);
        for (String windowString: DriverManager.getDriver().getWindowHandles()){
            if(!windowString.equals(homePageWindow)){
                DriverManager.getDriver().switchTo().window(windowString);
            }
        }
        String forgotPasswordPageTitle = forgotPasswordPage.ForgotPasswordPageText();
        Assert.assertEquals(forgotPasswordPageTitle,"Поиск аккаунта");
    }

    @Test
    public void loginTest(){
        DriverManager.getDriver().get("https://www.facebook.com/");
        HomePage homePage = new HomePage(DriverManager.getDriver());
        homePage.emailInput("123");
        homePage.passwordInput("456");
        FailedLogin failedLogin = homePage.clickLogInBtn();
        String failedLoginMessage = failedLogin.failedLogInPageMessage();
        Assert.assertEquals(failedLoginMessage, "Wrong credentials");
        ScreenshotUtils.makeScreenshot(DriverManager.getDriver(), "failedLogin");
    }
}
