package com.Satnam_Customer_scripts;

import org.testng.annotations.Test;

import com.Satnam_utilities.baseClass;
import com.Satnam_webpages.addNewCustomerPage;
import com.Satnam_webpages.openTasksPage;
import com.Satnam_webpages.projectsAndCustomersPage;

public class createCustomer_TC001 extends baseClass
{
	@Test
	public void testcreateCustomer_TC001()
	{
		openTasksPage otp=new openTasksPage();
		otp.clickProjectAndCustomerlink();
		log.info("*****ProjectAndCustomerlink is clicked*****");

		projectsAndCustomersPage pacp=new projectsAndCustomersPage();
		pacp.clickAddNewCustomerButton();
		log.info("*****AddNewCustomerButton is clicked*****");

		addNewCustomerPage ancp=new addNewCustomerPage();
		log.info("*****CustomerName is entered*****");
		ancp.clickcreateCustomerButton();
		log.info("*****CreateCustomerButton is clicked*****");
		String s=pacp.retriveMsg();
		System.out.println(s);
		log.info("*****Successful Msg is retrived*****");
	}
}
