package com.tyss.genericutility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tyss.genericutility.PropertyKey;
import com.tyss.genericutility.PropertyUtility;

public class WaitUtility {
	WebDriverWait wait;
	/**
	 * This generic method will use for giving implicit condition
	 */
	public void implicitlyWaitCondition(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(new PropertyUtility().getPropertyData(PropertyKey.TIMEOUT)),TimeUnit.SECONDS);
	}
	/**
	 * This generic method will wait for the alert
	 * @param driver
	 */
	public void explicitWaitForAlert(WebDriver driver) {
		wait=new WebDriverWait(driver, Integer.parseInt(new PropertyUtility().getPropertyData(PropertyKey.TIMEOUT)));
		wait.until(ExpectedConditions.alertIsPresent());

	}
	/**
	 * This generic method will wait for the specified WebElement to invisible
	 * @param driver
	 * @param element
	 */
	public void explicitWaitInvisibilityOfElement(WebDriver driver,WebElement element) {
		wait=new WebDriverWait(driver, Integer.parseInt(new PropertyUtility().getPropertyData(PropertyKey.TIMEOUT)));
		wait.until(ExpectedConditions.invisibilityOf(element));

	}
	/**
	 * This generic method will wait for the text to be present in element located
	 * @param driver
	 * @param locator
	 * @param text
	 */
	public void explicitWaittextToBePresentInElementLocated(WebDriver driver,By locator,String text) 
	{
		wait=new WebDriverWait(driver, Integer.parseInt(new PropertyUtility().getPropertyData(PropertyKey.TIMEOUT)));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));

	}
	/**
	 * This generic method will wait for the presence of element located
	 * @param driver
	 * @param locator
	 */
	public void explicitWaitPresentOfElementLocated(WebDriver driver,By locator) 
	{
		wait=new WebDriverWait(driver, Integer.parseInt(new PropertyUtility().getPropertyData(PropertyKey.TIMEOUT)));
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	/**
	 * This generic method will wait for webelement to be visible
	 * @param driver
	 * @param element
	 */
	public void explicitWaitVisibilityOf(WebDriver driver, WebElement element) 
	{
		wait=new WebDriverWait(driver, Integer.parseInt(new PropertyUtility().getPropertyData(PropertyKey.TIMEOUT)));
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public void explicitVisibilityOfElementLocated(WebDriver driver, By locator)
	{
		wait=new WebDriverWait(driver, Integer.parseInt(new PropertyUtility().getPropertyData(PropertyKey.TIMEOUT)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}


	public void waitAndSend(WebElement element, int duration, String data, long pollingTime)
	{
		int count=0;
		while(count<duration) 
		{
			try 
			{
				element.sendKeys(data);
				break;
			}
			catch(Exception e) 
			{
				try 
				{
					Thread.sleep(pollingTime);
				}
				catch (InterruptedException e1) 
				{
					e1.printStackTrace();
				}
				count=count+(int)pollingTime/1000;
			}
		}
	}

}


