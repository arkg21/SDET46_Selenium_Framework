package com.tyss.genericutility;

import org.openqa.selenium.WebElement;

public class VerificationUtility
{
/**
 * This method is used to verify actual, expected values
 * @param actual
 * @param expected
 * @param strategy
 */
	public void exactVerify(String actual, String expected,String strategy) 
	{
		if(strategy.equalsIgnoreCase("tc"))	
		{
			if (actual.equals(expected)) 
			{
				System.out.println("TC is pass");
			} 
			else 
			{
				System.out.println("TC is fail");
			}
		}
		else if(strategy.equalsIgnoreCase("page")) 
		{
			if (actual.equals(expected)) 
			{
				System.out.println(expected+" page is displayed");
			} 
			else 
			{
				System.out.println(expected+" page is not displayed");
			}
		}

	}
/**
 * This method is used to verify actual, expected values
 * @param actual
 * @param expected
 * @param strategy
 */
	public void partialVerify(String actual, String expected,String strategy) 
	{
		if(strategy.equalsIgnoreCase("tc"))	
		{
			if (actual.contains(expected)) 
			{
				System.out.println("TC is pass");
			} 
			else 
			{
				System.out.println("TC is fail");
			}
		}
		else if(strategy.equalsIgnoreCase("page")) 
		{
			if (actual.contains(expected)) 
			{
				System.out.println(expected+" page is displayed");
			} 
			else 
			{
				System.out.println(expected+" page is not displayed");
			}
		}
		else if(strategy.equalsIgnoreCase("Expected URL"))
		{
			if (actual.contains(expected)) 
			{
				System.out.println("Expected URL is been executed");
			} 
			else 
			{
				System.out.println("Expected URL is been executed");
			}	
		}
		else if(strategy.equalsIgnoreCase("text")) 
		{
			if (actual.equals(expected)) 
			{
				System.out.println(expected+" text is displayed");
			} 
			else 
			{
				System.out.println(expected+" text is not displayed");
			}
		}
		else if(strategy.equalsIgnoreCase("pop")) 
		{
			if (actual.equals(expected)) 
			{
				System.out.println(expected+" Pop-Up is displayed");
			} 
			else 
			{
				System.out.println(expected+"Pop-Up is not displayed");
			}
		}
	}
}