package com.qa.testCases;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.ContactsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.utils.ExcelDataConfig;
import com.qa.utils.TestUtils;

public class ContactTest extends TestBase{
	LoginPage login;
	HomePage home;
	TestUtils util;
	ContactsPage contacts;
	
	public ContactTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		login = new LoginPage();
		util = new TestUtils();
		contacts = new ContactsPage();
		home = login.loginPageTest(prop.getProperty("username"), prop.getProperty("password"));
		util.switchToFrame();
	    
	}
	
	@Test(priority=1)
		public void verifyLabelTest() {
		home.clickOnContactsLink();
		boolean flag = contacts.verifyContactLabel();
		Assert.assertTrue(flag,"Contact label is missing from page");
	}
	
	@Test(priority=2)
	public void selectSingleContactByName() {
		home.clickOnContactsLink();
		contacts.selectContactCheckbox("Rishabh Gupta");
	}
	
	@Test(priority=3)
	public void selectMultipleContactByName() {
		home.clickOnContactsLink();
		contacts.selectContactCheckbox("Rishabh Gupta");
		contacts.selectContactCheckbox("Pratibha Patel");
	}
	
	@DataProvider
	public Iterator<Object[]> getData() throws Exception {
		ArrayList<Object[]> ir = ExcelDataConfig.excelData("C:\\Users\\USER\\eclipse-workspace\\PageObjectDesignPattern\\src\\main\\java\\com\\qa\\testData\\TestData.xlsx");
        return ir.iterator();
	}
	
	
	
	@Test(priority=4,dataProvider="getData")
	public void createNewContractTest(String title,String firstName,String lastName,String company) {
		home.clickonNewContacts();
		contacts.createNewContact(title, firstName, lastName, company);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
}
