package com.tyss.genericutility.listener;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.tyss.genericutility.ConfigClass;
import com.tyss.genericutility.Constants;
import com.tyss.genericutility.PropertyKey;
import com.tyss.genericutility.PropertyUtility;
import com.tyss.genericutility.utilityinstanttransfer.UtilityInstanceTransfer;
import com.tyss.genericutility.Record;
import com.tyss.genericutility.ReportUtility;

public class ExtentReportsListener implements ITestListener, ISuiteListener 
{

	private ReportUtility report;
	public static ReportUtility sreport;

	@Override
	public void onStart(ITestContext context) 
	{

		System.out.println("OnStart ---> Test");
	}

	@Override
	public void onStart(ISuite suite) 
	{

		PropertyUtility propUtil = null;
		propUtil = new PropertyUtility();
		propUtil.initialize();
		report=new ReportUtility();
		report.init(Constants.EXTENT_REPORT_PATH,
				propUtil.getPropertyData(PropertyKey.EXTENTREPORTTITLE),
				propUtil.getPropertyData(PropertyKey.EXTENTREPORTNAME), propUtil.getPropertyData(PropertyKey.BROWSER));
		sreport=report;
	}

	@Override
	public void onFinish(ISuite suite) 
	{
		report.saveReport();
	}

	@Override
	public void onTestStart(ITestResult result) 
	{
		System.out.println("onTestStart");
		report.createTest(result.getMethod().getMethodName());
		Record reportAnnotation= result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Record.class);
		
		report.addAuthor(UtilityInstanceTransfer.getExtentTest(), reportAnnotation.author());
		report.addCategory(UtilityInstanceTransfer.getExtentTest(), reportAnnotation.category());
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		report.pass(UtilityInstanceTransfer.getExtentTest(),result.getMethod().getMethodName() + "PASS");
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		report.fail(UtilityInstanceTransfer.getExtentTest(),result.getMethod().getMethodName() + "FAIL", result.getThrowable());
		String screenshotPath = ConfigClass.class.cast(result.getMethod().getInstance()).sc.getScreenCapture();
		report.attachScreenshot(UtilityInstanceTransfer.getExtentTest(),screenshotPath, result.getMethod().getMethodName(), "base64");
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		report.skip(UtilityInstanceTransfer.getExtentTest(),result.getMethod().getMethodName() + "SKIPPED");
		report.skip(UtilityInstanceTransfer.getExtentTest(),result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		System.out.println("onTestFailedButWithinSuccessPercentage");
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) 
	{
		System.out.println("onTestFailedWithTimeout");
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		report.saveReport();
	}

}
