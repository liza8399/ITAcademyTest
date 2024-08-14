package com.itacademy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class BaseTest {
	protected WebDriver driver;

	@BeforeMethod
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", "/Users/elizavetafrolova/Library/chromedriver-mac-arm64/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@AfterMethod
	public void quit(){
		driver.quit();
	}
}
