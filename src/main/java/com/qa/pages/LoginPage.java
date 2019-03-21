package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//Define the page factories for login
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;

	@FindBy(xpath="//a[text()='Sign Up']")
	WebElement signUp;
	
	@FindBy(xpath="//a[@class='navbar-brand']//img[@class='img-responsive']")
	WebElement logo;
	
	
	//Initialize the webelements by driver
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions to be performed on webelements
	public String verifyTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyLogo() {
		return logo.isDisplayed();
	}
	
	public HomePage loginPageTest(String un,String pwd) throws InterruptedException {
		username.sendKeys(un);
		password.sendKeys(pwd);
		Thread.sleep(2000);
		loginBtn.click();
		
		return new HomePage();
	}
	
	public void setStatus() {
		System.out.println("Status Page Created");
	}
}
