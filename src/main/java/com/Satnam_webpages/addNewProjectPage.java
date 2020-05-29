package com.Satnam_webpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.Satnam_utilities.baseClass;

public class addNewProjectPage {
	
	@FindBy(name="customerId")
private WebElement customerNameDropdown;

@FindBy(name="name")
private WebElement projectNameTextField;

@FindBy(name="createProjectSubmit")
private WebElement createProjectButton;

public addNewProjectPage()
{
	PageFactory.initElements(baseClass.driver,this);
}

public void selectCustomerNameDropdown(String customerName)
{
	Select s1=new Select(customerNameDropdown);
	s1.selectByVisibleText(customerName);
}

public void enterProjectNameTextField(String projectName)
{
	projectNameTextField.sendKeys(projectName);
}

public void clickCreateProjectButton()
{
	createProjectButton.click();
}
	
}

