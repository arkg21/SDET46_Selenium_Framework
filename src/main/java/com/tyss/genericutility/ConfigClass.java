package com.tyss.genericutility;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import crm.salesandinventory.objectrepository.elements.LoginPage;
import crm.salesandinventory.objectrepository.elements.LogoutPage;

public class ConfigClass 
{
	protected PropertyUtility propertyutility;
	protected ExcelUtility excelutils;
	protected SelectUtility select;
	protected PopupUtility alert;
	protected WebDriverUtility webDriver;
	protected WaitUtility waitUtility;
	protected VerificationUtility verify;
	protected JavaUtility javaUtil;
	public WebDriver driver;
	protected LoginPage loginPage;
	public ScreenshotUtility sc; 

	@BeforeClass(alwaysRun = true)
	public void beforeTestSetup()
	{
		propertyutility=new PropertyUtility();
		excelutils=new ExcelUtility();
		select=new SelectUtility();
		alert=new PopupUtility();
		webDriver=new WebDriverUtility();
		waitUtility=new WaitUtility();
		verify=new VerificationUtility();
		javaUtil=new JavaUtility();
		String url=propertyutility.getPropertyData(PropertyKey.URL);
		driver=webDriver.openBrowser("chrome", url);
		System.out.println(driver);
		sc=new ScreenshotUtility();
		webDriver.maximizeBrowser();
		webDriver.implicitlyWaitCondition();
	}

	@BeforeMethod(alwaysRun = true)
	public void beforeMethodSetup()
	{
		
		String un=propertyutility.getPropertyData(PropertyKey.USERNAME);
		String pw=javaUtil.decoding(propertyutility.getPropertyData(PropertyKey.PASSWORD));
		loginPage=new LoginPage(driver);
		loginPage.loginToApp(un, pw);
		alert.initializeAlert(driver);
		alert.alertAccept();
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethodTearDown() 
	{
		LogoutPage lp;
		lp=new LogoutPage(driver);
		lp.SignOutAction();
	}

	@AfterClass(alwaysRun = true)
	public void afterClassTearDown()
	{
		webDriver.closeBrowser();
	}
}
