package com.mindtree.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {

	WebDriver driver;
	String path;

	public ScreenShot(WebDriver driver, String path) {
		this.path = path;
		this.driver = driver;
	}

	public String saveScreenShots(String name) throws IOException {
		TakesScreenshot shot = (TakesScreenshot) driver;
		File SrcFile = shot.getScreenshotAs(OutputType.FILE);
		String timeStamp = new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss.SS").format(new Date());
		String finalpath = path + name +"_"+timeStamp+ ".png";
		File DestFile = new File(finalpath);
		FileUtils.copyFile(SrcFile, DestFile);
		return finalpath;
	}
}
