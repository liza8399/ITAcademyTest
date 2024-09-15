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


public class FacebookTest extends BaseTest {

    @Test
    public void signUpTest(){
        DriverManager.getDriver().get("https://www.facebook.com/");
        HomePage homePage = new HomePage(DriverManager.getDriver());
//        homePage.clickCookies();
        Assert.assertEquals(homePage.getCreateNewAccountBtnText(), "Create new account");
        SignUpFormPage signUpFormPage = homePage.clickCreateNewAccountBtn();
        signUpFormPage.typeFirstName("123");
        signUpFormPage.typeLastName("456");
        signUpFormPage.typeEmail("123@gmail.com");
        signUpFormPage.sexChoice();
        ScreenshotUtils.makeScreenshot();
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
        Waiters.wait(20000);
        String failedLoginMessage = failedLogin.failedLogInPageMessage();
        Assert.assertEquals(failedLoginMessage, "The email address or mobile number you entered isn't connected to an account. Find your account and log in.");

    }
}
