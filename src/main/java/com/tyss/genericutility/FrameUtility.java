package com.tyss.genericutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
/**
 * This class contains re-usable methods for handling frames
 * @author arkg2
 *
 */
public class FrameUtility 
{
	/**
	 * This method is used to switch the frame based on index
	 * @param driver
	 * @param index
	 */
	public void switchFrame(WebDriver driver,int index) 
	{
		driver.switchTo().frame(index);
	}
	/**
	 * This method is used to switch the frame based on ID
	 * @param driver
	 * @param id
	 */
	public void switchFrame(WebDriver driver,String id) 
	{
		driver.switchTo().frame(id);
	}
	/**
	 * This method is used to switch the frame based on frame
	 * @param driver
	 * @param frame
	 */
	public void switchFrame(WebDriver driver,WebElement frame) 
	{
		driver.switchTo().frame(frame);
	}
}
