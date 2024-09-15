package com.itacademy.utils;

import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtils {
	static final Logger LOGGER = LogManager.getLogger(ScreenshotUtils.class);

	@Attachment(value = "Page screenshot", type = "image/png")
	public static byte[] makeScreenshot(){
		return ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
	}
}
