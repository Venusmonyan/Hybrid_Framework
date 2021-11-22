package com.mindtree.pageobjects;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.mindtree.helper.WebDriverHelper;
import com.mindtree.uistore.AppUI;
import com.mindtree.utilities.ExcelReading;
import com.mindtree.utilities.ExtentLogUtilities;
import com.mindtree.utilities.OpenChrome;
import com.mindtree.utilities.ReadPropertyFile;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import junit.framework.Assert;

public class LoginPage extends OpenChrome{
	ReadPropertyFile rps;
	static ExtentTest test;
	static ExtentReports report;
	WebDriverHelper wdh;
	public static Logger logger;
	
	public static void VerifyCaptcha(Logger logger,ExtentTest test,String name) throws IOException, InterruptedException {
		if(driver.getPageSource().contains(AppUI.captcha)) {
			logger.info("Captcha Screen Found");
			logger.info("Manually Solve the Captcha within 45 seconds");
			Thread.sleep(45000);
			logger = Logger.getLogger(LoginPage.class.getName());
			if(!driver.getPageSource().contains(AppUI.captcha)){
				logger.info("Captcha Verified Manually");
			}
			else {
				System.out.println("*******Captcha not Verified Manually*******");
				logger.error("Captcha was not Verified Manually");
				ExtentLogUtilities.fail(driver,test, "Captcha not Verified Manually",name);
				Assert.assertTrue(false);
			}
		}
	}
	
	@BeforeClass
	public void Initilize() throws FileNotFoundException, IOException {
		rps = new ReadPropertyFile();
		wdh = new WebDriverHelper();
		String timeStamp = new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss.SS").format(new Date());
		report = new ExtentReports(rps.getExtentReportPath()+"\\ExtentReportResults-"+timeStamp+"-.html");
		PropertyConfigurator.configure(rps.getlog4jPath());
		logger = Logger.getLogger(LoginPage.class.getName());
	}
	/* =======================================TEST CASES=======================================*/

	
	//Register the User with Invalid Email ID
	@Test(priority = 11,dataProvider="RegisterData")
	public void RegisterWith_InvalidEmail(String fName,String lName,String mail,String pass) throws IOException, InterruptedException {
		//Click the sign in Button
		driver.findElement(AppUI.signIn).click();

		//Creating ExtentReports
		String name = Thread.currentThread().getStackTrace()[1].getMethodName();
		test = report.startTest(name);

		//Click the create New Account button
		wdh.clicks(AppUI.createNewAccountlink, driver, logger, "Create new Account");

		//Elements of Firstname,lastname,email and Password for Registration
		wdh.sendText(AppUI.FirstName, driver, logger, fName,"First Name");
		wdh.sendText(AppUI.LastName, driver, logger, lName,"Last Name");
		wdh.sendText(AppUI.Email, driver, logger, mail,"Email");
		wdh.sendText(AppUI.Password, driver, logger, pass,"Password");
		logger.info("Entered the Registration Details");

		//Clicking on the create Account Button
		wdh.clicks(AppUI.createButton, driver, logger, "Create Account");
		
		//this code is for Manually Solving the captcha within 45 seconds
		Thread.sleep(2000);
		VerifyCaptcha(logger,test,name);

		//Verify if the Registration is Successfull or not
		if(driver.getTitle().contains(rps.getPageTitleAfterRegister()))
		{	
			ExtentLogUtilities.fail(driver,test, "Registered the User with Invalid EmailID",name);
			logger.error("Registered the User with Invalid EmailID");
			Assert.assertTrue(false);
		}
		else {
			logger.info("Failed to Register the User with Invalid EmailID");
			ExtentLogUtilities.pass(driver,test, "Registered the User with Invalid EmailID",name);
		}
		report.endTest(test);
		report.flush();
	}

	
	@Test(priority=12)
	public void loginWithEmptyDetails() throws FileNotFoundException, IOException, InterruptedException {
		//Creating ExtentReports and Logs
		String name = Thread.currentThread().getStackTrace()[1].getMethodName();
		test = report.startTest(name);

		//Click the sign in Button
		wdh.clicks(AppUI.signIn, driver, logger, "Sign In");
		
		//Type Nothing in Email and Password Text Field
		wdh.sendText(AppUI.loginEmail, driver, logger, "", "Email");
		wdh.sendText(AppUI.Password, driver, logger, "", "Password");
		logger.info("Entered The Details of Email and Password as Empty");

		//click on the Login Button
		wdh.clicks(AppUI.loginButton, driver, logger, "Login");

		//this code is for Manually Solving the captcha within 45 seconds
		Thread.sleep(2000);
		VerifyCaptcha(logger,test,name);

		//Verify if login is successfull or not
		if(driver.getPageSource().contains(AppUI.LogOut)) {
			ExtentLogUtilities.fail(driver,test, "User Logged in with Empty Login Details",name);
			logger.error("User Logged in with Empty Login Details");
			Assert.assertTrue(false);
		}
		else {
			ExtentLogUtilities.pass(driver,test, "User is not Logged in with Empty Login Details",name);
		}
		report.endTest(test);
		report.flush();
	}


	@Test(priority=13,dataProvider="LoginData")
	public void loginWithUserRegisteredDetails(String EmailID,String Password) throws FileNotFoundException, IOException, InterruptedException {
		//Creating ExtentReports and Logs
		String name = Thread.currentThread().getStackTrace()[1].getMethodName();
		test = report.startTest(name);
		
		//Click the sign in Button
		wdh.clicks(AppUI.signIn, driver, logger, "Sign In");

		Thread.sleep(2000);
		
		//Enter the Email and Password from the Excel Sheet
		wdh.sendText(AppUI.loginEmail, driver, logger, EmailID, "Email");
		wdh.sendText(AppUI.loginPass, driver, logger, Password, "Password");

		//Click on the Login Button
		wdh.clicks(AppUI.loginButton, driver, logger, "Login");

		//his code is for Manually Solving the captcha within 45 seconds
		Thread.sleep(2000);
		VerifyCaptcha(logger,test,name);

		//Verify if login is successfull or not
		if(driver.getPageSource().contains(AppUI.LogOut)) {
			logger.info("User Logged in with Valid Login Details");
			ExtentLogUtilities.pass(driver,test,"User is Logged in with Registered Login Details",name);
		}
		else {
			ExtentLogUtilities.fail(driver,test,"User is not Logged in with Registered Login Details",name);
			logger.error("User is not Logged in with Registered Login Details");
			Assert.assertTrue(false);
		}
		report.endTest(test);
		report.flush();
	}


	/* =======================================DATA PROVIDERS======================================= */
	
	//Data Provider for RegisterWith_InvalidEmail method
	@DataProvider(name="RegisterData") 
	String [][] getRegisterData() throws IOException
	{
		rps = new ReadPropertyFile();
		String excelPath = rps.getExcelDataPath();
		int sheetIndex = rps.getExcelRegisterDataIndex();
		int rowIndex = 1;

		ExcelReading ex = new ExcelReading(excelPath);
		int rownum=ex.get_Number_Of_Rows(sheetIndex);
		int colcount=ex.get_Number_Of_Cols(sheetIndex, rowIndex);

		String regData[][]=new String[rownum][colcount];

		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				regData[i-1][j]=ex.get_data(sheetIndex, i, j);
			}

		}
		return regData;
	}
	
	//Data Provider for loginWithUserRegisteredDetails method
	@DataProvider(name="LoginData")
	String [][] getLoginData() throws IOException
	{
		rps = new ReadPropertyFile();
		String excelPath = rps.getExcelDataPath();
		int sheetIndex = rps.getExcelLoginDataIndex();
		int rowIndex = 1;

		ExcelReading ex = new ExcelReading(excelPath);
		int rownum=ex.get_Number_Of_Rows(sheetIndex);
		int colcount=ex.get_Number_Of_Cols(sheetIndex, rowIndex);

		String logData[][]=new String[rownum][colcount];

		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logData[i-1][j]=ex.get_data(sheetIndex, i, j);
			}

		}
		return logData;
	}


}
