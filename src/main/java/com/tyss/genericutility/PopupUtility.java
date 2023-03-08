package com.tyss.genericutility;

import java.io.File;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Locale;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
/**
 * 
 * @author arkg2
 *
 */
public class PopupUtility 
{
	Alert a=null;

	public void initializeAlert(WebDriver driver) 
	{
		a=driver.switchTo().alert();	
	}
	/**
	 * This method will click on 'OK' button on the alert Pop-Up
	 */
	public void alertAccept() 
	{

		a.accept();

	}
	/**
	 * This method is used to click on 'Cancel' button of the alert pop up
	 */
	public void alertDismiss() 
	{
		a.dismiss();
	}
	/**
	 * This method is used to send the data to the alert box
	 * @param value
	 */
	public void alertSendKeys(String value) 
	{
		a.sendKeys(value);
	}
	/**
	 * This method will return the message present in the alert pop-up
	 * @return
	 */
	public String getTextOfAlert() 
	{
		return a.getText();
	}
	/**
	 * This method will disable all the notifications from Pop Up
	 * @param browserName
	 * @return
	 */
	public WebDriver disableNotification(String browserName) 
	{
		switch(browserName)
		{
		case "chrome":
		{
			ChromeOptions option=new ChromeOptions();
			option.addArguments("--disable notifications");
			WebDriver driver=new ChromeDriver(option);
			return driver;
		}
		case "firefox":
		{
			FirefoxOptions options=new FirefoxOptions();
			options.addArguments("--disable-notifications");
			WebDriver driver=new FirefoxDriver(options);
			return driver;
		}

		case "edge":
		{
			EdgeOptions options=new EdgeOptions();
			WebDriver driver=new EdgeDriver(options); 
			return driver; 
		}
		default :return null;
		}
	}
	/**
	 * This method is used to upload the file
	 * @param path
	 * @param webelement
	 */
	public void fileUpload(String path,WebElement webelement) 
	{
		File f=new File(path);
		webelement.sendKeys(f.getAbsolutePath());
	}
	/**
	 * This method is used to send the username and password to the url
	 * @param driver
	 * @param url
	 * @param username
	 * @param password
	 */
	public void autheticationPopup(WebDriver driver,String url,String username,String password) 
	{
		driver.get("https://"+username+":"+password+"@"+url.split("https://")[1]);
	}
	/**
	 * 
	 * @param currentMonthYear
	 * @param next
	 * @param previous
	 * @param reqMonth
	 * @param reqYear
	 */
	public void calender(WebElement currentMonthYear,WebElement next,WebElement previous,String reqMonth,String reqYear) 
	{
		int reqMonthNum=DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(reqMonth).get(ChronoField.MONTH_OF_YEAR);
		int reqYearNum=Integer.parseInt(reqYear);
		String curMonthYear=currentMonthYear.getText();
		int curMonthNum=DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(curMonthYear.split(" ")[0]).get(ChronoField.MONTH_OF_YEAR);
		int curYearNum=Integer.parseInt(curMonthYear.split(" ")[1]);
		while(reqMonthNum>curMonthNum||reqYearNum>curYearNum) 
		{
			next.click();
			curMonthYear=currentMonthYear.getText();
			curMonthNum=DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(curMonthYear.split(" ")[0]).get(ChronoField.MONTH_OF_YEAR);
			curYearNum=Integer.parseInt(curMonthYear.split(" ")[1]);
		}

		while(reqMonthNum<curMonthNum||reqYearNum<curYearNum) 
		{
			previous.click();
			curMonthYear=currentMonthYear.getText();
			curMonthNum=DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(curMonthYear.split(" ")[0]).get(ChronoField.MONTH_OF_YEAR);
			curYearNum=Integer.parseInt(curMonthYear.split(" ")[1]);
		}

	}
	/**
	 * This method is used to switch the window to the child window
	 * @param driver
	 * @param childWindowTitle
	 */
	public void switchTochildWindowPopup(WebDriver driver,String childWindowTitle) 
	{
		Set<String> windowHandles = driver.getWindowHandles();
		for(String windowHandle:windowHandles) {
			String actTitle=driver.switchTo().window(windowHandle).getTitle();
			if(actTitle.equalsIgnoreCase(childWindowTitle))
				break;
		}
	}
	/**
	 * This method is used to close only child window pop up
	 * @param driver
	 * @param closeWindowTitle
	 */
	public void closeChildWindow(WebDriver driver,String closeWindowTitle) 
	{
		Set<String> windowHandles = driver.getWindowHandles();
		for(String windowHandle:windowHandles) 
		{
			String actTitle=driver.switchTo().window(windowHandle).getTitle();
			if(actTitle.equalsIgnoreCase(closeWindowTitle)) 
			{
				driver.close();
				break;
			}	
		}

	}
	/**
	 * This method is used to close the windows except child window
	 * @param driver
	 * @param closeExceptWindowTitle
	 */
	public void closeExceptChildWindow(WebDriver driver,String closeExceptWindowTitle ) 
	{
		Set<String> windowHandles = driver.getWindowHandles();
		for(String windowHandle:windowHandles) 
		{
			String actTitle=driver.switchTo().window(windowHandle).getTitle();
			if(!(actTitle.equalsIgnoreCase(closeExceptWindowTitle))) 
			{
				driver.close();
				break;
			}	
		}

	}

}
