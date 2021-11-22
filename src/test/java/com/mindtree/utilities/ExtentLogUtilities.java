package com.mindtree.utilities;

import java.io.IOException;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class ExtentLogUtilities {
	public static void pass(WebDriver Driver, ExtentTest test, String msg,String methodName) throws IOException {
		test.log(LogStatus.PASS, msg);
		new ScreenShot(Driver,System.getProperty("user.dir") + "/ScreenShots/pass/").saveScreenShots(methodName);
	}

	public static void fail(WebDriver Driver, ExtentTest test, String msg,String methodName) throws IOException {
		test.log(LogStatus.FAIL, msg);
		new ScreenShot(Driver, System.getProperty("user.dir") + "/ScreenShots/fail/").saveScreenShots(methodName);
	}
}
