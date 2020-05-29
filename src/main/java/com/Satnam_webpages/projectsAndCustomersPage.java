package com.Satnam_webpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Satnam_utilities.baseClass;

public class projectsAndCustomersPage {
	
	@FindBy(xpath="//input[@value='Add New Customer']")
	private WebElement addNewCustomerButton;
	
	@FindBy(className="successmsg")
	private WebElement retriveMsg;
	
	@FindBy(xpath="//input[@value='Add New Project']")
	private WebElement addNewProject;
	
	public projectsAndCustomersPage()
	{
		PageFactory.initElements(baseClass.driver,this);
	}
	public void clickAddNewCustomerButton() {
		addNewCustomerButton.click();
	}
	
	public void clickAddNewProject()
	{
		addNewProject.click();
	}
	
	public String retriveMsg()
	{
		String s=retriveMsg.getText();
		return s;
	}
	
	
}
