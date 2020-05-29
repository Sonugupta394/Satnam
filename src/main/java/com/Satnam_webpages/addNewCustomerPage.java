package com.Satnam_webpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Satnam_utilities.baseClass;

public class addNewCustomerPage {
	
	@FindBy(name="name")
private WebElement CustomerNameTextField;

	@FindBy(name="createCustomerSubmit")
private WebElement createCustomerButton;

	public addNewCustomerPage()
	{
		PageFactory.initElements(baseClass.driver,this);
	}
	
	public void enterCustomerNameTextField(String customerName)
	{
		CustomerNameTextField.sendKeys(customerName);
	}
	public void clickcreateCustomerButton()
	{
		createCustomerButton.click();
		
	}
	
}
