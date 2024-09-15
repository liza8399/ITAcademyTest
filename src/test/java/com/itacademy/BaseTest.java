package com.itacademy;

import com.itacademy.enums.PropertiesValue;
import com.itacademy.listeners.SeleniumListener;
import com.itacademy.listeners.TestNGListener;
import com.itacademy.utils.ConfigurationReader;
import com.itacademy.utils.DriverFactory;
import com.itacademy.utils.DriverManager;
import com.itacademy.utils.ScreenshotUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.time.Duration;

@Listeners(TestNGListener.class)

public class BaseTest {

	protected WebDriver driver;



	@AfterMethod
	public void quit(){
		ScreenshotUtils.makeScreenshot();
		DriverManager.quit();
	}
}
