package com.tyss.genericutility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
/**
 * 
 * @author arkg2
 *
 */
public class JavascriptUtility 
{
	JavascriptExecutor j=null;
	/**
	 * This method is used to initialize
	 * @param driver
	 */
	public void initializeJavascript(WebDriver driver) 
	{
		j=(JavascriptExecutor) driver;
	}
	/**
	 * This method is used to scroll the document in the window by specified number of pixels
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void scroll(WebDriver driver,int x,int y) 
	{

		j.executeScript("window.scrollBy("+x+","+y+")");
	}
	/**
	 * This method is used to scroll the document in the window by given one axis
	 * @param element
	 */
	public void scroll(WebElement element) 
	{
		int y=element.getLocation().getY();
		j.executeScript("window.scrollBy(0,"+y+")");
	}
	/***
	 * This method is used to scroll to the bottom of page
	 */
	public void scrollBottom() 
	{
		j.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	/**
	 * This method is used to enter the disabled element values
	 * @param id
	 * @param value
	 */
	public void enterValueDisabledElement(String id,String value) 
	{
		j.executeScript("document.getElementByid("+id+").click("+value+")");
	}
	/**
	 * This method is used to click on disabled elements
	 * @param id
	 */
	public void clickDisabledElement(String id) 
	{
		j.executeScript("document.getElementByid("+id+").click()");
	}
}
