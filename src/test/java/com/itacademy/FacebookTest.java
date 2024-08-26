package com.itacademy;

import com.itacademy.pages.FailedLogin;
import com.itacademy.pages.ForgotPasswordPage;
import com.itacademy.pages.HomePage;
import com.itacademy.pages.SignUpFormPage;
import com.itacademy.utils.ScreenshotUtils;
import com.itacademy.utils.Waiters;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FacebookTest extends BaseTest {

    @Test
    public void exampleTestWithPageObject(){
        driver.get("https://www.facebook.com/");
        HomePage homePage = new HomePage(driver);
//        homePage.clickCookies();
        Assert.assertEquals(homePage.getCreateNewAccountBtnText(), "Создать новый аккаунт");
        SignUpFormPage signUpFormPage = homePage.clickCreateNewAccountBtn();
        signUpFormPage.typeFirstName("123");
        signUpFormPage.typeLastName("456");
        signUpFormPage.typeEmail("123@gmail.com");
        signUpFormPage.sexChoice();
        ScreenshotUtils.makeScreenshot(driver, "signupForm");
    }

    @Test
    public void forgotPasswordTest(){
        driver.get("https://www.facebook.com/");
        String homePageWindow = driver.getWindowHandle();
        HomePage homePage = new HomePage(driver);
        ForgotPasswordPage forgotPasswordPage = homePage.clickForgotPasswordBtn();
        Waiters.wait(3000);
        for (String windowString: driver.getWindowHandles()){
            if(!windowString.equals(homePageWindow)){
                driver.switchTo().window(windowString);
            }
        }
        String forgotPasswordPageTitle = forgotPasswordPage.ForgotPasswordPageText();
        Assert.assertEquals(forgotPasswordPageTitle,"Поиск аккаунта");
    }

    @Test
    public void loginTest(){
        driver.get("https://www.facebook.com/");
        HomePage homePage = new HomePage(driver);
        homePage.emailInput("123");
        homePage.passwordInput("456");
        FailedLogin failedLogin = homePage.clickLogInBtn();
        String failedLoginMessage = failedLogin.failedLogInPageMessage();
        Assert.assertEquals(failedLoginMessage, "Введенный вами электронный адрес или номер мобильного телефона не связан ни с одним аккаунтом. Найдите свой аккаунт и войдите в систему.");
        ScreenshotUtils.makeScreenshot(driver, "failedLogin");
    }
}
