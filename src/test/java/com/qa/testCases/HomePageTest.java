package com.qa.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.ContactsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.utils.TestUtils;

public class HomePageTest extends TestBase {

	LoginPage login;
	HomePage home;
	TestUtils util;
	ContactsPage contacts;
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		login = new LoginPage();
		util = new TestUtils();
		contacts = new ContactsPage();
		home = login.loginPageTest(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = home.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO","Home page title not matched");
	}
	
	@Test(priority=2)
	public void verifyUserNameTest() {
		util.switchToFrame();
		boolean flag = home.verifyUsername();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void verifyContactLinkTest() {
		util.switchToFrame();
		contacts = home.clickOnContactsLink();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
