package com.inetBanking.testCases;



import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	
	@Test
	public void loginTest() throws IOException,InterruptedException {
		driver.get(baseURL);
		driver.manage().window().maximize();
		logger.info("URL is opened");
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(username);
		lp.setPassword(password);
		logger.info("Username and password is entered");
		
		lp.clickSubmit();
		logger.info("Login button is clicked");
		
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")){
			captureScreen(driver,"loginTestPassed");
			Assert.assertTrue(true);
			logger.info("Login is passed");
		}
			else {
				captureScreen(driver,"loginTest");
				Assert.assertTrue(false);
			logger.info("Login is failed");
			}
		
		Thread.sleep(3000);
		
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Username/Password is incorrect");
		}
		else {
			Assert.assertTrue(true);
			lp.clickLogout();
			Thread.sleep(3000);
			logger.info("Login is passed");
			driver.switchTo().alert().accept();//close logout alert
			driver.switchTo().defaultContent();

		}
		}
	public boolean isAlertPresent() {
		try {
		driver.switchTo().alert();
		return true;
		}
		catch (NoAlertPresentException e) {
			return false;
		}
	}
	
	}
	
	
