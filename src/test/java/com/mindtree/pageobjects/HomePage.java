package com.mindtree.pageobjects;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.mindtree.helper.WebDriverHelper;
import com.mindtree.uistore.AppUI;
import com.mindtree.utilities.ExtentLogUtilities;
import com.mindtree.utilities.OpenChrome;
import com.mindtree.utilities.ReadPropertyFile;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;


public class HomePage extends OpenChrome{
	ReadPropertyFile rpf;
	static ExtentTest test;
	static ExtentReports report;
	WebDriverHelper wdh;
	public static Logger logger;
	
	@BeforeClass
	public void Initialize() throws FileNotFoundException, IOException {
		rpf = new ReadPropertyFile();
		wdh = new WebDriverHelper();
		String timeStamp = new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss.SS").format(new Date());
		report = new ExtentReports(rpf.getExtentReportPath()+"\\ExtentReportResults-"+timeStamp+"-.html");
		PropertyConfigurator.configure(rpf.getlog4jPath());
		logger = Logger.getLogger(HomePage.class.getName());
	}
	
	@Test(priority=1)
	public void clickingSearchBarIcon() throws InterruptedException, FileNotFoundException, IOException {
		//Name of the Method
		String name = Thread.currentThread().getStackTrace()[1].getMethodName();
		
		//creating the Extent Report File
		test = report.startTest(name);
		
		//Entering Text in Search Bar
		wdh.sendText(AppUI.SearchBar, driver, logger, rpf.getSearchText(), "Search Bar");
		
		//Clicking Search Icon in Home Page
		wdh.clicks(AppUI.SearchIcon, driver, logger, "Search Icon");
		
		//Checking the Post Condition After Clicking the Search Icon Button
		if(driver.getPageSource().contains(rpf.getSearchIconValidator())) {
			ExtentLogUtilities.pass(driver, test, "Clicked on the SearchIconButton, navigated to Search Found Page",name);
			logger.info("Search Icon Click PASSED, navigated to Search Found Page");
		}
		else {
			logger.error("Search Icon Click FAILED, coudn't navigate to Search Found Page");
			//Assert.assertTrue(false);
			ExtentLogUtilities.fail(driver, test, "Clicked on the SearchIconButton, coudn't navigate to Search Found Page",name);
		}
		report.endTest(test);
		report.flush();
	}
	
	@Test(priority=2)
	public void searchBarByEnterKey() throws InterruptedException, FileNotFoundException, IOException {
		
		//Getting the name of the method
		String name = Thread.currentThread().getStackTrace()[1].getMethodName();
//		logs = new LogUtility(name);
		
		test = report.startTest(name);
		
		//Entering Text in Search Bar
		wdh.sendText(AppUI.SearchBar, driver, logger, rpf.getSearchText(), "Search Bar");

		//Pressing Enter after Entering Text
		wdh.PressEnter(AppUI.SearchBar, driver, logger);
		
		//Verifying Search Found Page is Navigated After Pressing the Enter KEY
		if(driver.getPageSource().contains(rpf.getSearchIconValidator())) {
			logger.info("Navigated to Search Results Page");
			ExtentLogUtilities.pass(driver, test, "Navigated to Search Results Page",name);
		}
		else {
			logger.error("Error Navigating to Search Results Page");
//			Assert.assertTrue(false);
			ExtentLogUtilities.fail(driver, test, "Error Navigating to Search Results Page",name);
		}
		report.endTest(test);
		report.flush();
	}

	@Test(priority=3)
	public void personalizedGifts() throws FileNotFoundException, IOException, InterruptedException {
		
		//Getting the name of the method
		String name = Thread.currentThread().getStackTrace()[1].getMethodName();
//		logs = new LogUtility(name);
		test = report.startTest(name);
		
		//Click on the Personalized Gifts
		wdh.clicks(AppUI.PersonalizedGifts, driver, logger, "Personalized Gifts");
		Thread.sleep(1000);

		//Verifying the Personalized Gifts Page is Shown after Clicking the Personalized Gifts Button
		if(driver.getTitle().contains(rpf.getPersonalizedGiftsValidator())) {
			logger.info("Navigated to Personalized Gifts Page");
			ExtentLogUtilities.pass(driver, test, "Navigated to Personalized Gifts Page",name);
		}
		else {
			logger.error("Error Navigation to Personalized Gifts Page");
//			Assert.assertTrue(false);
			ExtentLogUtilities.fail(driver, test, "Error Navigation to Personalized Gifts Page",name);
		}
		report.endTest(test);
		report.flush();
	}
	@Test(priority=4)
	public void newModule() throws FileNotFoundException, IOException, InterruptedException {
		
		//Getting the name of the method
		String name = Thread.currentThread().getStackTrace()[1].getMethodName();
//		logs = new LogUtility(name);
		test = report.startTest(name);
		
		//Click on the New Module in Nav Bar
		wdh.clicks(AppUI.newModule, driver, logger, "new");
		Thread.sleep(1000);

		//Verifying the What's new Page is Shown after Clicking the New Module Button
		if(driver.getTitle().contains(rpf.getNewModuleValidator())) {
			ExtentLogUtilities.pass(driver, test, "Navigated to What's New Page",name);
			logger.info("Navigated to What's New Page");
		}
		else {
			logger.error("Error Navigation to What's New Pag");
			ExtentLogUtilities.fail(driver, test, "Error Navigation to What's New Page",name);
//			Assert.assertTrue(false);
		}
		report.endTest(test);
		report.flush();
	}
	@Test(priority=5)
	public void topFiftyModule() throws FileNotFoundException, IOException, InterruptedException {
		
		//Getting the name of the method
		String name = Thread.currentThread().getStackTrace()[1].getMethodName();
//		logs = new LogUtility(name);
		test = report.startTest(name);
		
		//Click on the Top50 button
		wdh.clicks(AppUI.topFifty, driver, logger, "TOP50");
		Thread.sleep(1000);

		//Verifying the Most Popular Gifts Page is Shown after Clicking the Top50 Button
		if(driver.getTitle().contains(rpf.getTopFiftyValidator())) {
			logger.info("Navigated to Most Popular Gifts Page");
			ExtentLogUtilities.pass(driver, test, "Navigated to Most Popular Gifts Page",name);
		}
		
		else {
			logger.error("Error Navigation to Most Popular Gifts Page");
			ExtentLogUtilities.fail(driver, test, "Error Navigation to Most Popular Gifts Page",name);
//			Assert.assertTrue(false);
		}
		report.endTest(test);
		report.flush();
	}
	@Test(priority=6)
	public void christmasGifts() throws FileNotFoundException, IOException, InterruptedException {
		
		//Getting the name of the method
		String name = Thread.currentThread().getStackTrace()[1].getMethodName();
//		logs = new LogUtility(name);
		test = report.startTest(name);
		
		//Click on the Christmas Gifts button in Nav bar
		wdh.clicks(AppUI.christmasGifts, driver, logger, "Christmas Gifts");
		Thread.sleep(1000);

		//Verifying the Christmas Gifts Page is Shown after Clicking the Christmas Gifts button
		if(driver.getTitle().contains(rpf.getChristmasGiftsValidator())) {
			logger.info("Navigated to Christmas Gifts Page");
			ExtentLogUtilities.pass(driver, test, "Navigated to Christmas Gifts Page",name);
		}
		else {
			logger.error("Error Navigation to Christmas Gifts Page");
			ExtentLogUtilities.fail(driver, test, "Error Navigation to Christmas Gifts Page",name);
//			Assert.assertTrue(false);
		}
		report.endTest(test);
		report.flush();
	}
	@Test(priority=7)
	public void secretChristmasGifts() throws FileNotFoundException, IOException, InterruptedException {
		//Getting the name of the method
		String name = Thread.currentThread().getStackTrace()[1].getMethodName();
//		logs = new LogUtility(name);
		test = report.startTest(name);
		
		//Click on the Secret Christmas Gifts button in Nav bar
		wdh.clicks(AppUI.secretChristmasGifts, driver, logger, "Secret Christmas Gifts");
		Thread.sleep(1000);

		//Verifying the All of it Secret Christmas Gifts is Shown after Clicking the Secret Christmas Gifts button
		if(driver.getTitle().contains(rpf.getSecretChristmasGiftsValidator())) {
			logger.info("Navigated to Secret Christmas Gifts Page");
			ExtentLogUtilities.pass(driver, test, "Navigated to Secret Christmas Gifts Page",name);
		}
		else {
			ExtentLogUtilities.fail(driver, test, "Error Navigation to Secret Christmas Gifts Page",name);
			logger.error("Error Navigation to Secret Christmas Gifts Page");
//			Assert.assertTrue(false);
		}
		report.endTest(test);
		report.flush();
	}
	@Test(priority=8)
	public void allOfIt() throws FileNotFoundException, IOException, InterruptedException {

		//Getting the name of the method
		String name = Thread.currentThread().getStackTrace()[1].getMethodName();
//		logs = new LogUtility(name);
		test = report.startTest(name);
		
		//Click on the All of it button in Nav bar
		wdh.clicks(AppUI.allOfIt, driver, logger, "All of It");
		Thread.sleep(1000);

		//Verifying the All of it Gifts Page is Shown after Clicking the All of it button
		if(driver.getTitle().contains(rpf.getAllOfItValidator())) {
			logger.info("Navigated to All of it Gifts Page");
			ExtentLogUtilities.pass(driver, test, "Navigated to All of it Gifts Page",name);
		}
		else {
			logger.info("Error Navigation to All of it Gifts Page");
			ExtentLogUtilities.fail(driver, test, "Error Navigation to All of it Gifts Page",name);
//			Assert.assertTrue(false);
		}
		report.endTest(test);
		report.flush();
	}

	@Test(priority=9)
	public void giftCards() throws FileNotFoundException, IOException, InterruptedException {
		rpf = new ReadPropertyFile();
		//Getting the name of the method
		String name = Thread.currentThread().getStackTrace()[1].getMethodName();
//		logs = new LogUtility(name);
		test = report.startTest(name);
		
		//Click on the Gift Cards button
		wdh.clicks(AppUI.giftCard, driver, logger, "Gift Cards");
		Thread.sleep(1000);

		//Verifying the Gift Cards Page is Shown after Clicking the Gift Cards button
		if(driver.getTitle().contains(rpf.getGiftCardValidator())) {
			logger.info("Navigated to Gift Cards Page");
			ExtentLogUtilities.pass(driver, test, "Navigated to Gift Cards Page",name);
		}
		else {
			logger.error("Error Navigation to Gift Cards Page");
//			Assert.assertTrue(false);
			ExtentLogUtilities.fail(driver, test, "Navigated to Gift Cards Page",name);
		}
		report.endTest(test);
		report.flush();
	}
	@Test(priority=10)
	public void wishList() throws FileNotFoundException, IOException, InterruptedException {
		
		//Getting the name of the method
		String name = Thread.currentThread().getStackTrace()[1].getMethodName();
//		logs = new LogUtility(name);
		test = report.startTest(name);
		
		//Click on the Wish List button
		wdh.clicks(AppUI.wishList, driver, logger, "Wish List");
		Thread.sleep(1000);

		//Verifying the Gift Cards Page is Shown after Clicking the Gift Cards button
		if(driver.getTitle().contains(rpf.getWishListValidator())) {
			logger.info("Navigated to Wish List Page");
			ExtentLogUtilities.pass(driver, test, "Navigated to Wish List Page",name);
		}
		else {
			logger.error("Error Navigation to Wish List Page");
//			Assert.assertTrue(false);
			ExtentLogUtilities.fail(driver, test, "Error Navigation to Wish List Page",name);
		}
		report.endTest(test);
		report.flush();
	}
}
