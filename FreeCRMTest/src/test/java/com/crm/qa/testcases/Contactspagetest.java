package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class Contactspagetest extends TestBase {
	LoginPage loginPage;
	HomePage  homepage;
	ContactsPage contactpage;
	String sheetName = "contacts";
	
	public Contactspagetest() {
		super();
	}
	@BeforeMethod()
	public void setup() throws InterruptedException {
		initialization();
		contactpage = new ContactsPage();
		loginPage = new LoginPage();
		homepage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		Thread.sleep(2000);
		contactpage =homepage.clickOnContacts();
		Thread.sleep(2000);
	}
	@Test(priority=1)
	public void verifyContactsPageLabel() {
		Assert.assertTrue(contactpage.verifyContactsLabel(),"contact label is missing on the page");
	}
	@Test(priority=2)
	public void selectContactsTest() throws InterruptedException {
		Thread.sleep(2000);
		contactpage.selectContactsByName("Amit Kumar Das");
		contactpage.selectContactsByName("Asit Kumar Das");
	}
	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] =  TestUtil.getTestData(sheetName);
		return data;	
	}
	@Test(priority=3,dataProvider="getCRMTestData")
    public void validateCreatenewContact(String FirstName,String LastName,String MiddleName){
		contactpage.ClickOnNewContact();
		contactpage.CreateNewContact(FirstName,LastName,MiddleName);
    //  contactpage.CreateNewContact("Ajit","ku.","Das");
	}
	
	@AfterMethod
	public void tearDownMethod(){
	    driver.quit();
	  }
}
