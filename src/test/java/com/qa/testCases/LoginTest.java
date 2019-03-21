package com.qa.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class LoginTest extends TestBase {
    LoginPage login;
	HomePage home;
	public LoginTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		login = new LoginPage();
	}
	
	@Test(priority=1)
	public void titleVerificationTest() {
		String title = login.verifyTitle();
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
	
	@Test(priority=2)
	public void crmLogoVerificationTest() {
		boolean flag = login.verifyLogo();
		Assert.assertTrue(flag);
		}
	
	@Test(priority=3)
	public void loginTestVerification() throws InterruptedException {
		 home = login.loginPageTest(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
