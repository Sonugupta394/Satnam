package com.Satnam_utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class frameWorkListener extends TestListenerAdapter
{

	ExtentHtmlReporter reporter;
	ExtentReports extent;
	ExtentTest test;

	public void onStart(ITestContext rv)
	{
		String date=new SimpleDateFormat("yyyymmddhhMMss").format(new Date());
		String reportName="Test-Report"+date+".html";
		reporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"//test-output//"+reportName);
		reporter.config().setDocumentTitle("Demo Test");
		reporter.config().setReportName("Build Result");
		reporter.config().setTheme(Theme.DARK);
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("QA","Sonu");
		extent.setSystemInfo("OS","WIN 10");
		extent.setSystemInfo("Browser","Chrome 81");
	}
	public void onFinish(ITestContext rv)
	{
		extent.flush();
	}
	public void onTestStart(ITestResult rv)
	{
		test.getExtent().createTest(rv.getName());
	}
	public void onTestSuccess(ITestResult rv)
	{
		test=extent.createTest(rv.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("Successfully Execute", ExtentColor.GREEN));
	}
	public void onTestFailure(ITestResult rv)
	{
		test=extent.createTest(rv.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel("failed Execution", ExtentColor.RED));
		EventFiringWebDriver efw=new EventFiringWebDriver(baseClass.driver);
		File f1 = efw.getScreenshotAs(OutputType.FILE);
		String date=new SimpleDateFormat("yyyymmddhhMMss").format(new Date());
		String path=System.getProperty("user.dir")+"//screenshots//"+date+".jpg";
		File f2 = new File(path);
		try {
			FileUtils.copyFile(f1, f2);
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void onTestSkipped(ITestResult rv)
	{
		test=extent.createTest(rv.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel("Execution Skipped", ExtentColor.ORANGE));
	}
}
