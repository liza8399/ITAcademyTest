package com.itacademy;

import com.itacademy.utils.DriverManager;
import com.itacademy.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class IndiaTest extends BaseTest{


	@Test
	public void login(){
		DriverManager.getDriver().get("https://rahulshettyacademy.com/angularpractice/");
		WebElement nameInputField = DriverManager.getDriver().findElement(By.name("name"));
		nameInputField.sendKeys("Liza");

		WebElement emailInputField = DriverManager.getDriver().findElement(By.name("email"));
		emailInputField.sendKeys("");

		WebElement checkbox = DriverManager.getDriver().findElement(By.xpath("//*[@type='checkbox']"));
		checkbox.click();
		checkbox.click();
		Assert.assertTrue(checkbox.isSelected());
		checkbox.click();
		Assert.assertFalse(checkbox.isSelected());

		// To check this alert, it is needed to click something on the page. So we do this check here
		WebElement alertText = DriverManager.getDriver().findElement(By.cssSelector(".alert.alert-danger"));
		Assert.assertEquals(alertText.getText(),"Email is required");
		Assert.assertTrue(alertText.isDisplayed());

		Select selectElement = new Select(DriverManager.getDriver().findElement(By.id("exampleFormControlSelect1")));
		selectElement.selectByIndex(0);
		selectElement.selectByVisibleText("Female");
		Assert.assertEquals((selectElement.getFirstSelectedOption().getText()), "Female");

		WebElement radioBtn = DriverManager.getDriver().findElement(By.id("inlineRadio1"));
		radioBtn.click();
		Assert.assertTrue(radioBtn.isSelected());

		WebElement radioBtn2 = DriverManager.getDriver().findElement(By.id("inlineRadio2"));
		radioBtn2.click();
		Assert.assertTrue(radioBtn2.isSelected());


		WebElement submit = DriverManager.getDriver().findElement(By.xpath("//input[@value='Submit']"));
		submit.click();
		Waiters.wait(3000);
		WebElement successAlert = DriverManager.getDriver().findElement(By.cssSelector(".alert.alert-success.alert-dismissible"));
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
