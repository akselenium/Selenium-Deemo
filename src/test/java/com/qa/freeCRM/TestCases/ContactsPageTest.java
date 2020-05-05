package com.qa.freeCRM.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.CRM.qa.Base.TestBase;
import com.qa.pages.freeCRMTest.ContactsPage;
import com.qa.pages.freeCRMTest.HomePage;
import com.qa.pages.freeCRMTest.LoginPage;

public class ContactsPageTest extends TestBase
{
	 LoginPage loginpage;
	 HomePage homepage;
	 ContactsPage contactspage;
	 
	 public ContactsPageTest() 
	 {
		 super();
	 }
	 
	
	 @BeforeMethod
	 public void setUp() 
	 {
		 intialisation(); 
		 loginpage = new LoginPage();
		 contactspage= new ContactsPage();
		 homepage =loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		 contactspage =homepage.contactLink();
	 }
	 
	 @Test(priority=0)
	 public void verifycontactsLOGO() 
	 {
		 Assert.assertTrue(contactspage.verifyContactLogo(),"contacts labels are missing on the page");
	 }
	 
	 @Test(priority=1)
	 public void selectContactsTest() 
	 {
		 driver.navigate().refresh(); 
		 contactspage.selectContactsByName("Ajit MMM");
	 }
	 
	 @Test(priority=2)
	 public void validateNewContact() throws InterruptedException 
	 {
		 contactspage.clickOnNewContact();
		 
		 driver.navigate().refresh();
		 Thread.sleep(10000);
		 contactspage.createNewContact("som","peter","spetrhgd@gmail.com");
	 }
	 
	 
	 
	 
	 
	 @AfterMethod
	 public void logout() throws InterruptedException 
	 {
		 Thread.sleep(3000);
		 //driver.quit();
	 }
	
	
	
	

}
