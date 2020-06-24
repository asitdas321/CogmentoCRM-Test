package com.crm.qa.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	@FindBy(xpath="//div[@class='ui header item mb5 light-black']")
	WebElement contactslabel;
	
	@FindBy(xpath="//button[contains(text(),'New')]")
	WebElement newContact;
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement FirstName;
	
	@FindBy(xpath="//input[@name='last_name']")
	WebElement LastName;
	
	@FindBy(xpath="//input[@name='middle_name']")
	WebElement MiddleName;
	
	@FindBy(xpath="//button[@class='ui linkedin button']")
	WebElement SaveBtn;
	
	@FindBy(xpath="//span[contains(text(),'Active')]")
	WebElement Status;
	
	public ContactsPage() {
		PageFactory.initElements(driver,this);	
	}
	
	public boolean verifyContactsLabel() {
		return contactslabel.isDisplayed();
	
	}
	
	public void selectContactsByName(String name) {
		driver.findElement(By.xpath("//td[contains(text(),'"+name+"')]")).click();
		
	}
	
    public void ClickOnNewContact() {
	newContact.click();
	
    }
	
	public void CreateNewContact(String ftName, String ltName,String midName) {
		FirstName.sendKeys(ftName);
		LastName.sendKeys(ltName);
		MiddleName.sendKeys(midName);
		SaveBtn.click();
		
	}
	

}
