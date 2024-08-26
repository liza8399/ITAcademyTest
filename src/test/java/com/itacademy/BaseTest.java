package com.itacademy;

import com.itacademy.enums.PropertiesValue;
import com.itacademy.listeners.SeleniumListener;
import com.itacademy.listeners.TestNGListener;
import com.itacademy.utils.ConfigurationReader;
import com.itacademy.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.time.Duration;

@Listeners(TestNGListener.class)

public class BaseTest {

	protected WebDriver driver;

	@BeforeMethod
	public void setUp(){
		driver = DriverFactory.createDriver(ConfigurationReader.getProperty(PropertiesValue.BROWSER));
		EventFiringDecorator<WebDriver> decorator = new EventFiringDecorator<>(new SeleniumListener());
		driver = decorator.decorate(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@AfterMethod
	public void quit(){
		driver.quit();
	}
}
