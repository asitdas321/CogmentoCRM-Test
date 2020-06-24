package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath=" //span[@class='user-display']")
	WebElement userNameLabel;
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")   
	WebElement contacts;
	
	
	@FindBy(xpath="//span[contains(text(),'Deals')]")   
	WebElement deals;
	
	
	@FindBy(xpath="//span[contains(text(),'Tasks')]")   
	WebElement tasks;
	
	//Initializing the page objects: 
	public HomePage() {
		PageFactory.initElements(driver,this);	
	}
		
		//Action
		public String verifyHomepageTitle() {
			return driver.getTitle();
		
		}
		public boolean verifyCorrectUserName() {
			return userNameLabel.isDisplayed();
			
		}
		
		public ContactsPage clickOnContacts() {
			contacts.click();
			return new ContactsPage();
		}
		public DealsPage clickOnDeals() {
			deals.click();
			return new DealsPage();
		}
		public TaskPage clickOnTasks() {
			tasks.click();
			return new TaskPage();
			
		}
}


	
		
			
			

	

