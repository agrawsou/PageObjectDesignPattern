package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactLabel;
	
	@FindBy(xpath="//select[@name='title']")
	WebElement title;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement lastName;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath="//input[@name='addmore']//preceding-sibling::input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactLabel() {
		return contactLabel.isDisplayed();
	}
	
	public void selectContactCheckbox(String name) {
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']//preceding-sibling::td//input[@name='contact_id']")).click();
	}
	
	public void createNewContact(String designation,String ftName,String ltName,String comName) {
		Select select = new Select(title);
		select.selectByVisibleText(designation);
		
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		company.sendKeys(comName);
		saveBtn.click();
		
	}
	

}
