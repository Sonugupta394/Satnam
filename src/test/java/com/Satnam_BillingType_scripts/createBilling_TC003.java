package com.Satnam_BillingType_scripts;

import org.testng.annotations.Test;

import com.Satnam_utilities.baseClass;
import com.Satnam_webpages.addNewBillingTypesPage;
import com.Satnam_webpages.billingTypesPage;
import com.Satnam_webpages.openTasksPage;
public class createBilling_TC003 extends baseClass
{
	@Test
	public void testCreateBilling_TC003()
	{
		openTasksPage otp=new openTasksPage();
		otp.clickSettingsLink();
		log.info("*****SettingsLink is clicked*****");
		
		billingTypesPage btp=new billingTypesPage();
		btp.clickAddNewBillingTypeButton();
		log.info("*****AddNewBillingTypeButton is clicked*****");
		
		addNewBillingTypesPage anbtp=new addNewBillingTypesPage();
		anbtp.enterBillingTypeNameTextField("pai4444145");
		log.info("*****BillingTypeNameTextField is entered*****");
		
		anbtp.clickCreateBillingTypeButton();
		log.info("*****CreateBillingTypeButton is clicked*****");
		
		String s=btp.retriverMsg();
		System.out.println(s);
		log.info("*****SuccessMsg is retrived*****");
		
	}
}
