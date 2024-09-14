package com.itacademy.utils;

import com.itacademy.enums.PropertiesValue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

	public static WebDriver createDriver(String browserName) {

		if (browserName.equals("chrome")) {
			ChromeOptions chromeOptions = new ChromeOptions();
			Map<String, Object> prefs = new HashMap<>();
			prefs.put("intl.accept_languages", "en-US");
			chromeOptions.setExperimentalOption("prefs", prefs);
			URL url = null;
			try {
				url = new URL(ConfigurationReader.getProperty(PropertiesValue.SELENIUM_URL));
			} catch (MalformedURLException e) {
				throw new RuntimeException(e);
			}
			return new RemoteWebDriver(url, chromeOptions);
		} else if (browserName.equals("firefox")) {
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			URL url = null;
			try {
				url = new URL("http://localhost:4444");
			} catch (MalformedURLException e) {
				throw new RuntimeException(e);
			}
			return new RemoteWebDriver(url, firefoxOptions);
		} else {
			return null;
		}
	}
}

