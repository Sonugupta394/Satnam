package com.Satnam_webpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Satnam_utilities.baseClass;

public class addNewBillingTypesPage {

	@FindBy(name="name0")
	private WebElement billingTypeNameTextField;
	
	@FindBy(xpath="//input[@value='Create Billing Type(s)']")
	private WebElement createBillingTypeButton;
	
	public addNewBillingTypesPage()
	{
		PageFactory.initElements(baseClass.driver,this);
	}
	
	public void enterBillingTypeNameTextField(String data)
	{
		billingTypeNameTextField.sendKeys(data);
	}
	
	public void clickCreateBillingTypeButton()
	{
		createBillingTypeButton.click();
	}
}
