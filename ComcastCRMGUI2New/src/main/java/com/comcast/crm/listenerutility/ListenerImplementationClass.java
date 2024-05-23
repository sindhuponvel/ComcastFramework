package com.comcast.crm.listenerutility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.baseutility.BaseClass;

public class  ListenerImplementationClass implements ITestListener, ISuiteListener {

	// public ExtentSparkReporter spark;

	public ExtentReports report;

	public  static ExtentTest test;

	@Override
	public void onStart(ISuite suite) // similar to before suite
	{
		System.out.println("Report Congiguration");
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report_"+time+"html"); // to set a path | similar
																							// to fileinputstream
		spark.config().setDocumentTitle("Product result");
		spark.config().setReportName("CRM report");
		spark.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("Browser", "Chome-12");

	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("Report backup");
		report.flush();

	}

	@Override
	public void onTestStart(ITestResult result)// similar to before method
	{
		test = report.createTest(result.getMethod().getMethodName());
		System.out.println("======>" + result.getMethod().getMethodName() + "<===START=====");

		test.log(Status.INFO, result.getMethod().getMethodName() + "====>STARTED<=====");

	}

	@Override
	public void onTestSuccess(ITestResult result) {

		System.out.println("======>" + result.getMethod().getMethodName() + "<====END====");
		test.log(Status.PASS, result.getMethod().getMethodName() + "====>COMPLETED<=====");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();

		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		TakesScreenshot ts= (TakesScreenshot)BaseClass.sdriver;
	    String filePath=ts.getScreenshotAs(OutputType.BASE64);
		//String time = new Date().toString().replace(" ","_").replace(":","_");
	    //test.addScreenCaptureFromBase64String(filePath,testName+"_"+time+".html");
		
		test.log(Status.FAIL, result.getMethod().getMethodName() + "====>FAILED<=====");

	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
