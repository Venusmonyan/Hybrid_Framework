package com.mindtree.helper;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


public class WebDriverHelper {

	public void sendText(By by,WebDriver driver,Logger logger,String keys,String name) {
		driver.findElement(by).click();
		driver.findElement(by).clear();
		driver.findElement(by).sendKeys(keys);
		logger.info("Successfully Entered the Text: \""+keys+"\" in the "+name+" Field");
	}
	
	public void clicks(By by,WebDriver driver,Logger logger,String buttonName) {
		driver.findElement(by).click();
		logger.info("Successfully clicked \""+buttonName+"\" Button");
	}
	
	public void PressEnter(By by,WebDriver driver,Logger logger)
	{
	driver.findElement(by).sendKeys(Keys.ENTER);
	logger.info("Successfully Pressed the ENTER button In Keyboard)]");
	}
	
}
