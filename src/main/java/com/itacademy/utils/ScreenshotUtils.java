package com.itacademy.utils;

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

	public static void makeScreenshot(WebDriver driver, String fileName){
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d.MM-HH.MM.ss");
		Date date = new Date();
		String currentDateString = simpleDateFormat.format(date);
		simpleDateFormat.format(date);
		File file1 = new File(fileName + currentDateString + ".png");
		try {
			FileUtils.copyFile(file, file1);
		} catch (IOException e) {
			LOGGER.info("Screenshot wasn't saved");
		}
	}
}
