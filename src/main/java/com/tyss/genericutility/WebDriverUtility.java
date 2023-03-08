package com.tyss.genericutility;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.tyss.genericutility.PropertyKey;
import com.tyss.genericutility.PropertyUtility;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author arkg2
 *
 */
public class WebDriverUtility 
{
	private WebDriver driver=null;
	/**
	 * This generic method will open the browser 
	 * @param browserName
	 * @param url
	 */
	public WebDriver openBrowser(String browserName,String url) 
	{
		switch(browserName)
		{
		case "chrome":
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.get(url);
			break;

		}
		case "firefox":
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			driver.get(url);
			break;
		}

		case "edge":
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			driver.get(url);
			break;
		}

		}
		return driver;
	}
	/**
	 * This generic method will maximize the browser
	 */
	public void maximizeBrowser() 
	{
		driver.manage().window().maximize();
	}
	/**
	 * This generic method will close the browser
	 */
	public void closeBrowser() 
	{
		driver.close();
	}
	/**
	 * This generic method will fetch the current url
	 */
	public void getUrl() 
	{
		driver.getCurrentUrl();
	}
	/**
	 * This generic method will fetch the title of the window
	 */
	public void getWindowtitle() 
	{
		driver.getTitle();

	}
	/**
	 * This generic method will use for giving implicit condition
	 */
	public void implicitlyWaitCondition() 
	{
		driver.manage().timeouts().implicitlyWait(Long.parseLong(new PropertyUtility().getPropertyData(PropertyKey.TIMEOUT)),TimeUnit.SECONDS);
	}
	/**
	 * This generic method will navigate the web page to specified url
	 * @param url
	 */
	public void navigateToUrl(String url) 
	{
		driver.navigate().to(url);
	}
	/**
	 * This generic method will click on back button
	 */
	public void back() 
	{
		driver.navigate().back();

	}
	/**
	 * This generic method will click on forward button
	 */
	public void forward() 
	{
		driver.navigate().forward();
	}
	/**
	 * This generic method will refresh the web page
	 */
	public void refresh() 
	{
		driver.navigate().refresh();
	}
}
