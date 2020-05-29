package com.Satnam_Project_scripts;


import org.testng.annotations.Test;

import com.Satnam_utilities.baseClass;
import com.Satnam_webpages.addNewProjectPage;
import com.Satnam_webpages.openTasksPage;
import com.Satnam_webpages.projectsAndCustomersPage;


public class createProject_TC002 extends baseClass
{

	@Test
	public void testCreateProject_TC002() 
	{ 
		//String customerName=excelOperation.readData("Sheet2", 1,1);
		//	String projectName=excelOperation.readData("Sheet2", 1,2);

		openTasksPage otp=new openTasksPage();
		otp.clickProjectAndCustomerlink();
		log.info("*****ProjectAndCustomerlink is clicked*****");
		projectsAndCustomersPage pacp=new projectsAndCustomersPage();
		pacp.clickAddNewProject();
		log.info("*****AddNewProjectButton is clicked*****");

		addNewProjectPage anpp=new addNewProjectPage();
		anpp.selectCustomerNameDropdown("aa");
		log.info("*****CustomerName is selected*****");

		anpp.enterProjectNameTextField("cfl4g");
		log.info("*****ProjectName is entered*****");

		anpp.clickCreateProjectButton();
		log.info("*****CreateProjectButton is clicked*****");
		String s=pacp.retriveMsg();
		System.out.println(s);
		log.info("*****Success Msg is retrived*****");
	}
}