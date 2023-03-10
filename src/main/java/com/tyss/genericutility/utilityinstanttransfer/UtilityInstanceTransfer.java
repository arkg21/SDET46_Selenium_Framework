package com.tyss.genericutility.utilityinstanttransfer;

import com.aventstack.extentreports.ExtentTest;

public class UtilityInstanceTransfer 
{

	private static ThreadLocal<ExtentTest> extentTest=new ThreadLocal<>();
	
	public static ExtentTest getExtentTest() 
	{
		return extentTest.get();
	}
	
	public static void setExtentTest(ExtentTest setExtentTest) 
	{
		extentTest.set(setExtentTest);
	}
	
}
