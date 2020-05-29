package com.Satnam_webpages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.Satnam_utilities.baseClass;

public class addNewTasksPage {

	@FindBy(name="customerId")
	private WebElement customerNameDropdown;

	@FindBy(name="projectId")
	private WebElement projectNameDropdown;

	@FindBy(name="task[0].name")
	private WebElement tasksNameTextfield;

	@FindBy(xpath="//img[@alt='Click Here to Pick up the timestamp']")
	private WebElement selectDate;

	@FindBy(name="year")
	private WebElement selectYear;

	@FindBy(name="month")
	private WebElement selectMonth;

	//@FindBy(xpath="//span[text()=' ']")
	//private WebElement enterDate;

	@FindBy(name="task[0].billingType")
	private WebElement billingType;

	@FindBy(xpath="//input[@value='Create Tasks']")
	private WebElement createTasksbutton;
	
	private String homeWindow;

	public addNewTasksPage()
	{
		PageFactory.initElements(baseClass.driver,this);
	}

	public void selectCustomerNameDropdown(String CustpmerName)
	{
		Select s1=new Select(customerNameDropdown);
		s1.selectByVisibleText(CustpmerName);
	}

	public void selectProjectNameDropdown(String projectName)
	{
		Select s2=new Select(projectNameDropdown);
		s2.selectByVisibleText(projectName);
	}

	public void enterTasksNameTextfield(String tasksName)
	{
		tasksNameTextfield.sendKeys(tasksName);
	}

	public void selectDateInTasks()
	{
		selectDate.click();
	}

	public void switchToWindow(WebDriver driver) {
		 homeWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
	
		 Iterator<String> iterator = windows.iterator();

		while(iterator.hasNext()) {
			String win = iterator.next();
			if(! homeWindow.equals(win)) {
				driver.switchTo().window(win);
			}
		}

	}
	public void selectYear(String year)
	{
		Select y1=new Select(selectYear);
		y1.selectByVisibleText(year);
	}
	public void selectMonth(String month)
	{
		Select m1=new Select(selectMonth);
		m1.selectByVisibleText(month);		
	}
	public void enterDate(String date, WebDriver driver)
	{
		
		String xpath = "//span[text()='"+date+"']";
		WebElement enterDate = driver.findElement(By.xpath(xpath));
		enterDate.click();
	}
	
	public void switchBackToHomeWindow(WebDriver driver) {
		driver.switchTo().window(homeWindow);
	}

	public void billingType(String billing)
	{
		Select b1=new Select(billingType);
		b1.selectByVisibleText(billing);
	}

	public void clickCreateTasksbutton()
	{
		createTasksbutton.click();
	}
}
