package com.tyss.genericutility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
/**
 * 
 * @author arkg2
 *
 */
public class ScreenshotUtility 
{
	TakesScreenshot t=null;
	/**
	 * This constructor will initialize the TakesScreenshot instance
	 * @param driver
	 */
	private WebDriver driver;
	
	/**
	 * This generic method will take the screenshot
	 */
	public void getScreenshot() 
	{

		File src=t.getScreenshotAs(OutputType.FILE);
		try 
		{
			FileUtils.copyFile(src,new File( Constants.TEST_SCREENSHOT_FILE_PATH));
		} catch (IOException e) 

		{
			e.printStackTrace();
		}
	}
	public String getScreenCapture()
	{
		TakesScreenshot ts= (TakesScreenshot) driver;
		
		return ts.getScreenshotAs(OutputType.BASE64);
	}
}
