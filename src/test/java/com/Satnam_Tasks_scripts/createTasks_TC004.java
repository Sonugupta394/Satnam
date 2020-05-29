package com.Satnam_Tasks_scripts;

import org.testng.annotations.Test;

import com.Satnam_utilities.baseClass;
import com.Satnam_webpages.addNewTasksPage;
import com.Satnam_webpages.openTasksPage;

public class createTasks_TC004 extends baseClass
{
	@Test
	public void testCreateTasks_TC004() 
	{
		openTasksPage otp=new openTasksPage();
		otp.clickAddNewTasks();
		log.info("*****AddNewTasksButton is clicked******");

		addNewTasksPage antp=new addNewTasksPage();
		antp.selectCustomerNameDropdown("aa");
		log.info("*****CustomerName is selected*****");

		antp.selectProjectNameDropdown("aa1");
		log.info("*****ProjectName is selected*****");

		antp.enterTasksNameTextfield("procees44s44ing");
		log.info("*****TasksName is entered*****");

		antp.selectDateInTasks();
		log.info("*****DateIcon is selected*****");
		
		antp.switchToWindow(driver);

		antp.selectYear("2015");
		log.info("*****Year is selected*****");

		antp.selectMonth("May");
		log.info("*****MonthName is selected*****");

		antp.enterDate("17", driver);
		log.info("*****Date is selected*****");

		antp.switchBackToHomeWindow(driver);
		
		antp.billingType("Billable");
		log.info("*****BillingType is selected*****");

		antp.clickCreateTasksbutton();
		log.info("*****CreateTasksButton is clicked*****");

		String s=otp.retriveMsg();
		System.out.println(s);
		log.info("*****SuccessMsg is retrived*****");
	}
}
