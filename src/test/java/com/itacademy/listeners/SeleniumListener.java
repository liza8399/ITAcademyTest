package com.itacademy.listeners;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

@Log4j2
public class SeleniumListener implements WebDriverListener {

	@Override
	public void afterQuit(WebDriver driver) {
		log.info("Driver quit");
	}

	@Override
	public void afterClick(WebElement element) {
		log.info(element.toString().split("->")[1] + "is clicked");
	}


}
