package com.itacademy;

import com.itacademy.utils.Waiters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.lang.ref.SoftReference;
import java.time.Duration;

public class IndiaTest extends BaseTest{

	static final Logger LOGGER = LogManager.getLogger(IndiaTest.class);

	@Test
	public void login(){
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		WebElement nameInputField = driver.findElement(By.name("name"));
		nameInputField.sendKeys("Liza");

		WebElement emailInputField = driver.findElement(By.name("email"));
		emailInputField.sendKeys("");

		WebElement checkbox = driver.findElement(By.xpath("//*[@type='checkbox']"));
		checkbox.click();
		checkbox.click();
		Assert.assertTrue(checkbox.isSelected());
		checkbox.click();
		Assert.assertFalse(checkbox.isSelected());

		// To check this alert, it is needed to click something on the page. So we do this check here
		WebElement alertText = driver.findElement(By.cssSelector(".alert.alert-danger"));
		Assert.assertEquals(alertText.getText(),"Email is required");
		Assert.assertTrue(alertText.isDisplayed());

		Select selectElement = new Select(driver.findElement(By.id("exampleFormControlSelect1")));
		selectElement.selectByIndex(0);
		selectElement.selectByVisibleText("Female");
		Assert.assertEquals((selectElement.getFirstSelectedOption().getText()), "Female");

		WebElement radioBtn = driver.findElement(By.id("inlineRadio1"));
		radioBtn.click();
		Assert.assertTrue(radioBtn.isSelected());

		WebElement radioBtn2 = driver.findElement(By.id("inlineRadio2"));
		radioBtn2.click();
		Assert.assertTrue(radioBtn2.isSelected());


		WebElement submit = driver.findElement(By.xpath("//input[@value='Submit']"));
		submit.click();
		Waiters.wait(3000);
		WebElement successAlert = driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible"));
		String successAlertText = successAlert.getText();
		successAlertText = successAlertText.replaceAll("×\\n","");
		Assert.assertEquals(successAlertText,"Success! The Form has been submitted successfully!.");
	}

	@Test
	public void checkAsserts(){
		SoftAssert sa = new SoftAssert();
		sa.assertEquals("1","2");
		sa.assertEquals("2","2");
		sa.assertEquals("2", "3");
		sa.assertAll();


	}


}
