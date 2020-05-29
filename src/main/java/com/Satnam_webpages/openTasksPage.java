package com.Satnam_webpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Satnam_utilities.baseClass;

public class openTasksPage {
	
	@FindBy(linkText="Projects & Customers")
	private WebElement projectAndCustomerlink;
	
	@FindBy(linkText="Settings")
	private WebElement settingsLink;
	
	@FindBy(xpath="//input[@value='Add New Tasks']")
	private WebElement addNewTasks;
	
	@FindBy(className="successmsg")
	private WebElement retriveMsg;
	
	public openTasksPage()
	{
		PageFactory.initElements(baseClass.driver,this);
	}
	public void clickProjectAndCustomerlink()
	{
		projectAndCustomerlink.click();
	}
	
	public void clickSettingsLink()
	{
		settingsLink.click();
	}
	
	public void clickAddNewTasks()
	{
		addNewTasks.click();
	}
	
	public String retriveMsg() {
		String s=retriveMsg.getText();
		return s;
	}
}
