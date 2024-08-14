package com.itacademy;

import com.itacademy.utils.ActionsUtils;
import com.itacademy.utils.ScreenshotUtils;
import com.itacademy.utils.Waiters;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class NewWebsiteTest extends BaseTest{

	static final Logger LOGGER = LogManager.getLogger(NewWebsiteTest.class);

	@Test
	public void frametest(){
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		Waiters.wait(3000);
		List<WebElement> list = driver.findElements(By.xpath("//*[text()='All Access plan']"));
		LOGGER.info(list.size());
		ScreenshotUtils.makeScreenshot(driver, "frame");
		driver.switchTo().frame("courses-iframe");
		List<WebElement> list1 = driver.findElements(By.xpath("//*[text()='All Access plan']"));
		System.out.println(list1.size());
		driver.switchTo().defaultContent();

	}

	@Test
	public void alerttest(){
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("alertbtn")).click();
		Alert alert1 = driver.switchTo().alert();
		String alertText1 = alert1.getText();
		Assert.assertEquals(alertText1,"Hello , share this practice page and share your knowledge");
		alert1.accept();

		driver.findElement(By.id("confirmbtn")).click();
		Alert alert2 = driver.switchTo().alert();
		String alertText2 = alert2.getText();
		Assert.assertEquals(alertText2,"Hello , Are you sure you want to confirm?");
		alert2.dismiss();
		}


	@Test
	public void hidenelementtest(){
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebElement hiddenInput = driver.findElement(By.xpath("//*[@name ='show-hide']"));
		Assert.assertTrue(hiddenInput.isDisplayed());
		driver.findElement(By.id("hide-textbox")).click();
		Assert.assertFalse(hiddenInput.isDisplayed());
		driver.findElement(By.id("show-textbox"));
		Assert.assertTrue(hiddenInput.isDisplayed());
	}

	@Test
	public void tabtest(){
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//		System.out.println(driver.getWindowHandle());
//		driver.getWindowHandles().stream().forEach(System.out::println);
		String mainWindow = driver.getWindowHandle();
		driver.findElement(By.id("opentab")).click();
		Waiters.wait(3000);
		for (String windowString: driver.getWindowHandles()){
			if(!windowString.equals(mainWindow)){
				driver.switchTo().window(windowString);
			}
		}
		Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Access all our Courses']")).isDisplayed());
		driver.close();
		driver.switchTo().window(mainWindow);
	}

	@Test
	public void windowtest(){
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		String mainWindow = driver.getWindowHandle();
		driver.findElement(By.id("openwindow")).click();
		Waiters.wait(3000);
		for (String windowString: driver.getWindowHandles()){
			if(!windowString.equals(mainWindow)){
				driver.switchTo().window(windowString);
			}
		}
		Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Access all our Courses']")).isDisplayed());
		driver.close();
		driver.switchTo().window(mainWindow);
	}

	@Test
	public void hoverTest(){
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		ActionsUtils.hoverAndClick(driver, driver.findElement(By.id("mousehover")),
				driver.findElement(By.xpath("//*[text()='Top']")));
		ActionsUtils.hoverAndClick(driver, driver.findElement(By.id("mousehover")),
				driver.findElement(By.xpath("//*[text()='Reload']")));
		Waiters.wait(1000);
	}




}

