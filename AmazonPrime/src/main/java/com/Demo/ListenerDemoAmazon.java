package com.Demo;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerDemoAmazon implements ITestListener  {
	
	ExtentReports er;
	ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		String name = result.getName();
		test  = er.createTest(name) ;
	}

	public void onTestSuccess(ITestResult result) {
		String name = result.getName();
		test.log(Status.PASS,name+"--->Passed");
	}

	public void onTestFailure(ITestResult result) {
		String name = result.getName();
		test.log(Status.FAIL,name+"--->Failed");
	}

	public void onTestSkipped(ITestResult result) {
		String name = result.getName();
		test.log(Status.SKIP, name+"--->Skipped");
	}

	public void onStart(ITestContext context) {
		ExtentSparkReporter esr = new ExtentSparkReporter(".\\ExtentReport\\"+1+".html");
		esr.config().setDocumentTitle("Amazon Demo Report");
		esr.config().setTheme(Theme.STANDARD);
		esr.config().setReportName("manojKumar");
		
		er = new ExtentReports();
		er.attachReporter(esr);
		
		er.setSystemInfo("Operating System","Windows");
	}

	public void onFinish(ITestContext context) {
		er.flush();
	}
		
	
}
