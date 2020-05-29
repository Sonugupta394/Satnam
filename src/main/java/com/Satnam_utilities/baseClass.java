package com.Satnam_utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;


import io.github.bonigarcia.wdm.WebDriverManager;

public class baseClass {

	public static WebDriver driver;
	FileInputStream fis;
	Properties p1;

	public static Logger log;
	@BeforeTest
	public void openBrowser() throws IOException
	{
		log=Logger.getLogger(baseClass.class);
		PropertyConfigurator.configure("log4j.properties");

		fis=new FileInputStream(System.getProperty("user.dir")+"//App.properties");
		p1=new Properties();
		p1.load(fis);

		String browser="firefox";
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//drivers//chromedriver.exe");
			//WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			log.info("*****Chrome Browser is opened*****");
		}
		else if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"//drivers//geckodriver.exe");
			driver=new FirefoxDriver();
			log.info("*****Firefox Browser is opened*****");
		}

		else
		{
			System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"//drivers//IEDriverServer.exe");
			driver=new InternetExplorerDriver();
			log.info("*****InternetExplorer Browser is opened*****");
		}
	}
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
		log.info("***** Browser is Closed*****");
	}

	@BeforeClass
	public void login()
	{
		driver.get(p1.getProperty("URL"));
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.name("username")).sendKeys(p1.getProperty("UN"));
		driver.findElement(By.name("pwd")).sendKeys(p1.getProperty("PWD"));
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		log.info("*****Login is Successful*****");
	}

	@AfterClass
	public void logout()
	{

		driver.findElement(By.className("logoutImg")).click();	
		log.info("*****Logout is successful*****");
	}
}
