package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class Homepagetest extends TestBase {
	LoginPage loginPage;
	HomePage  homepage;
	ContactsPage contactpage;
	
	public Homepagetest() {
		super();
	}
	
	@BeforeMethod()
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		homepage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		homepage.clickOnContacts();
	}
	
	@Test(priority = 1)
	public void verifyHomepageTitleTest() {
	String homepageTitle = 	homepage.verifyHomepageTitle();
	Assert.assertEquals(homepageTitle,"Cogmento CRM","Home page title not matched");		
	}
	
	@Test(priority =2)
	public void verifyUserNameTest() {
		Assert.assertTrue(homepage.verifyCorrectUserName());	
	}
	
	@Test(priority=3)
	public void checkContactTest() {
		contactpage = homepage.clickOnContacts();
	}
	
    @AfterMethod
    public void tearDownMethod(){
	   driver.quit();
	   
	   
   }
}
