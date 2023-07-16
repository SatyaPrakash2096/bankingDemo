package com.inetBanking.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass{
	
	@Test
	public void AddNewCustomer() throws IOException,InterruptedException {
		LoginPage lp = new LoginPage(driver);
		driver.manage().window().maximize();
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickSubmit();
		
		logger.info("Customer logged in");
		Thread.sleep(3000);
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		
		addcust.clickAddNewCustomer();
		addcust.custName(readconfig.getName());
		addcust.custgender("male");
		addcust.custdob("10","08","1991");
		Thread.sleep(3000);
		addcust.custcity("Bangalore");
		addcust.custaddress("Sample address");
		addcust.custstate("Karnataka");
		addcust.custpinno(randomeNumber());
		addcust.custtelephoneno("9988009988");
		
		addcust.custemailid(randomeString()+"@gmail.com");
		addcust.custpassword("abcdf12");
		logger.info("Customer Details added");
		addcust.custsubmit();
		
		Thread.sleep(3000);
		
		logger.info("Validation started");
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(res==true) {
			Assert.assertTrue(true);
			logger.info("Test case is passed....");
		}
		else {
			captureScreen(driver,"addNewCustomer");
			logger.info("Test case is failed....");
			Assert.assertTrue(false);
			
		}
	}
	
}
