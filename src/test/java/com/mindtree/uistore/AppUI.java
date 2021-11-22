package com.mindtree.uistore;

import org.openqa.selenium.By;

public class AppUI {
	
/* Elements used in HomePage */
public static By SearchBar = By.name("q");
public static By SearchIcon = By.xpath("//*[@id=\"myheader\"]/div[1]/header/div[2]/div[2]/div[3]/form/div/img");
public static By PersonalizedGifts = By.xpath("//*[@id=\"myheader\"]/div[1]/div/div/ul/li[2]/a");
public static By newModule = By.xpath("//*[@id=\"myheader\"]/div[1]/div/div/ul/li[3]/a");
public static By topFifty = By.xpath("//*[@id=\"myheader\"]/div[1]/div/div/ul/li[6]/a");
public static By christmasGifts = By.xpath("//*[@id=\"myheader\"]/div[1]/div/div/ul/li[4]/a");
public static By secretChristmasGifts = By.xpath("//*[@id=\"myheader\"]/div[1]/div/div/ul/li[5]/a");
public static By allOfIt = By.xpath("//*[@id=\"myheader\"]/div[1]/div/div/ul/li[12]/a");
public static By sortBy = By.xpath("//*[@id=\"shopify-section-collection-header\"]/div/header/div[1]/div");
public static By giftCard = By.xpath("//*[@id=\"myheader\"]/div[1]/header/div[2]/div[2]/div[4]/div/div/a[3]/i");
public static By wishList= By.xpath("//*[@id=\"myheader\"]/div[1]/header/div[2]/div[2]/div[4]/div/div/a[2]/i");

/* Elements used in LoginPage */
public static By signIn = By.xpath("//*[@id=\"myheader\"]/div[1]/header/div[2]/div[2]/div[4]/div/div/a[1]/span");
public static By LoginPageValidator = By.xpath("//*[@id=\"MainContent\"]/div/div[1]/div/header/h1");

//For Registering User 
public static By createNewAccountlink = By.id("customer_register_link");
public static By Email = By.id("Email");
public static By Password = By.id("CreatePassword");
public static By FirstName = By.id("FirstName");
public static By LastName= By.id("LastName");
public static By createButton = By.xpath("//*[@id=\"create_customer\"]/p/input");
public static By myAccount = By.xpath("//*[@id=\"myheader\"]/div[1]/header/div[2]/div[2]/div[4]/div/div/a[1]/span");
public static String LogOut = "Log out";
public static String captcha ="To continue, let us know you're not a robot.";

//For User Login
public static By loginEmail = By.id("CustomerEmail");
public static By loginPass = By.id("CustomerPassword");
public static By loginButton = By.xpath("//*[@id=\"customer_login\"]/p[1]/input");

}
