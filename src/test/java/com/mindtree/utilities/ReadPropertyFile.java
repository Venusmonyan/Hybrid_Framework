package com.mindtree.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {
	Properties RPS = new Properties();
	Properties ElementRPS = new Properties();
	FileInputStream fis;
	
	public ReadPropertyFile() throws IOException,FileNotFoundException {
	FileInputStream fis=new FileInputStream("./ConfigurationFiles/Config.properties");
	FileInputStream elementFile =new FileInputStream("./ConfigurationFiles/Elements.properties");
	RPS.load(fis);
	ElementRPS.load(elementFile);
	}
	
	
	//Methods for Elements Property File
	//============================================================================================================================
	public String getSearchIconValidator() {
		String SearchIconValidator = ElementRPS.getProperty("SearchIconValidatorText");
		if(SearchIconValidator!=null) {
			return SearchIconValidator;
		}
		else
			throw new RuntimeException("SearchIconValidator NOT SPECIFIED");
	}
	public String getLoginPageValidator() {
		String LoginPageValidator = ElementRPS.getProperty("LoginPageValidator");
		if(LoginPageValidator!=null) {
			return LoginPageValidator;
		}
		else
			throw new RuntimeException("LoginPageValidator NOT SPECIFIED");
	}
	public String getSearchText() {
		String SearchText = ElementRPS.getProperty("SearchText");
		if(SearchText!=null) {
			return SearchText;
		}
		else
			throw new RuntimeException("SearchText NOT SPECIFIED");
	}
	public String getPersonalizedGiftsValidator() {
		String PageTitleValidatorForPersonalizedGifts = ElementRPS.getProperty("PageTitleValidatorForPersonalizedGifts");
		if(PageTitleValidatorForPersonalizedGifts!=null) {
			return PageTitleValidatorForPersonalizedGifts;
		}
		else
			throw new RuntimeException("PageTitleValidatorForNewModule NOT SPECIFIED");
	}
	public String getNewModuleValidator() {
		String NewModuleValidator = ElementRPS.getProperty("PageTitleValidatorForNewModule");
		if(NewModuleValidator!=null) {
			return NewModuleValidator;
		}
		else
			throw new RuntimeException("PageTitleValidatorForPersonalizedGifts NOT SPECIFIED");
	}
	public String getTopFiftyValidator() {
		String TopFiftyValidator = ElementRPS.getProperty("PageTitleValidatorForTopFifty");
		if(TopFiftyValidator!=null) {
			return TopFiftyValidator;
		}
		else
			throw new RuntimeException("PageTitleValidatorForTopFifty NOT SPECIFIED");
	}
	
	public String getChristmasGiftsValidator() {
		String ChristmasGiftsValidator = ElementRPS.getProperty("PageTitleValidatorForChristmasGifts");
		if(ChristmasGiftsValidator!=null) {
			return ChristmasGiftsValidator;
		}
		else
			throw new RuntimeException("ChristmasGiftsValidator NOT SPECIFIED");
	}
	
	public String getSecretChristmasGiftsValidator() {
		String SecretChristmasGiftsValidator = ElementRPS.getProperty("PageTitleValidatorForSecretChristmasGifts");
		if(SecretChristmasGiftsValidator!=null) {
			return SecretChristmasGiftsValidator;
		}
		else
			throw new RuntimeException("PageTitleValidatorForSecretChristmasGifts NOT SPECIFIED");
	}
	
	public String getAllOfItValidator() {
		String AllOfIt = ElementRPS.getProperty("PageTitleValidatorForAllOfIt");
		if(AllOfIt!=null) {
			return AllOfIt;
		}
		else
			throw new RuntimeException("PageTitleValidatorForAllOfIt NOT SPECIFIED");
	}
	public String getGiftCardValidator() {
		String GiftCardValidator = ElementRPS.getProperty("PageValidatorForGiftCard");
		if(GiftCardValidator!=null) {
			return GiftCardValidator;
		}
		else
			throw new RuntimeException("PageValidatorForGiftCard NOT SPECIFIED");
	}
	public String getWishListValidator() {
		String WishList = ElementRPS.getProperty("PageValidatorForWishList");
		if(WishList!=null) {
			return WishList;
		}
		else
			throw new RuntimeException("PageValidatorForWishList NOT SPECIFIED");
	}
	public String getAccountValidator() {
		String AccountValidator = ElementRPS.getProperty("AccountValidator");
		if(AccountValidator!=null) {
			return AccountValidator;
		}
		else
			throw new RuntimeException("AccountValidator NOT SPECIFIED");
	}
	
	public String getPageTitleAfterRegister() {
		String PageTitleAfterRegister = ElementRPS.getProperty("PageTitleAfterRegister");
		if(PageTitleAfterRegister!=null) {
			return PageTitleAfterRegister;
		}
		else
			throw new RuntimeException("PageTitleAfterRegister NOT SPECIFIED");
	}
	public int getExcelRegisterDataIndex() {
		String Index = ElementRPS.getProperty("ExcelUserRegisterDataIndex");
		if(Index!=null) {
			return Integer.parseInt(Index);
		}
		else
			throw new RuntimeException("ExcelUserRegisterDataIndex NOT SPECIFIED");
	}
	public int getExcelLoginDataIndex() {
		String Index = ElementRPS.getProperty("ExcelUserLoginDataIndex");
		if(Index!=null) {
			return Integer.parseInt(Index);
		}
		else
			throw new RuntimeException("ExcelUserLoginDataIndex NOT SPECIFIED");
	}
	//============================================================================================================================
	
	
	
	//****************************************************************************************************************************	
	//Methods For Config Property File
	
	public String getChromeDriverPath() {
		String getDriverPath = RPS.getProperty("ChromeDriverPath");
		if(getDriverPath!=null) {
			return getDriverPath;
		}
		else
			throw new RuntimeException("ChromeDriverPath NOT SPECIFIED");
	}
	
	public String getHeaderParaContent() {
		String HeaderParaContent = RPS.getProperty("HeaderParaContent");
		if(HeaderParaContent!=null) {
			return HeaderParaContent;
		}
		else
			throw new RuntimeException("HeaderParaContent NOT SPECIFIED");
	}
	public String getloggerName() {
		String loggerName = RPS.getProperty("loggerName");
		if(loggerName!=null) {
			return loggerName;
		}
		else
			throw new RuntimeException("loggerName NOT SPECIFIED");
	}
	
	public String getTestname() {
		String Testname = RPS.getProperty("Testname");
		if(Testname!=null) {
			return Testname;
		}
		else
			throw new RuntimeException("Testname NOT SPECIFIED");
	}
	public String getlog4jPath() {
		String log4jPath = RPS.getProperty("log4jPath");
		if(log4jPath!=null) {
			return log4jPath;
		}
		else
			throw new RuntimeException("log4jPath NOT SPECIFIED");
	}
	
	public String getChromeDriverKey() {
		String ChromeDriverKey = RPS.getProperty("ChromeDriverKey");
		if(ChromeDriverKey!=null) {
			return ChromeDriverKey;
		}
		else
			throw new RuntimeException("ChromeDriverKey NOT SPECIFIED");
	}
	
	public String geturl() {
		String url = RPS.getProperty("url");
		if(url!=null) {
			return url;
		}
		else
			throw new RuntimeException("URL NOT SPECIFIED");
	}
	
	public String getExtentReportPath() {
		String ExtentReportPath = RPS.getProperty("ExtentReportPath");
		if(ExtentReportPath!=null) {
			return ExtentReportPath;
		}
		else
			throw new RuntimeException("ExtentReportPath NOT SPECIFIED");
	}
	public String getExcelDataPath() {
		String ExcelDataPath = RPS.getProperty("ExcelDataPath");
		if(ExcelDataPath!=null) {
			return ExcelDataPath;
		}
		else
			throw new RuntimeException("ExcelDataPath NOT SPECIFIED");
	}
	
	public int getimplicitWait() {
		String implicitWait = RPS.getProperty("implicitWait");
		int Iw = 0;
		if(implicitWait!=null) {
			try {
				Iw =Integer.parseInt(implicitWait);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return Iw;
		}
		else
			throw new RuntimeException("ImplicitWait NOT SPECIFIED");
	}

	

	
}
