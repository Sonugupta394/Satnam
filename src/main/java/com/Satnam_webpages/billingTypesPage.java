package com.Satnam_webpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Satnam_utilities.baseClass;

public class billingTypesPage {

	@FindBy(xpath="//input[@value='Add New Billing Type']")
	private WebElement addNewBillingTypeButton;
	
	@FindBy(className="successmsg")
	private WebElement retriverMsg;
	
	public billingTypesPage()
	{
		PageFactory.initElements(baseClass.driver,this);
	}
	
	public void clickAddNewBillingTypeButton()
	{
		addNewBillingTypeButton.click();
	}
	
	public String retriverMsg()
	{
		String s=retriverMsg.getText();
		return s;
	}
}
