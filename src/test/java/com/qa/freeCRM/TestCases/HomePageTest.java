package com.qa.freeCRM.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.CRM.qa.Base.TestBase;
import com.qa.pages.freeCRMTest.ContactsPage;
import com.qa.pages.freeCRMTest.HomePage;
import com.qa.pages.freeCRMTest.LoginPage;





public class HomePageTest extends TestBase
{
 LoginPage loginpage;
 HomePage homepage;
 ContactsPage contactspage;
 
 public HomePageTest() 
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
 }
 
 @Test(priority=0)
 public void homepageTitleTest() 
 {
	 String title=homepage.homePageTitle();
	 Assert.assertEquals(title,"Cogmento CRM","Home Page Title will misMatch");
 }
 
 @Test(priority=1)
 public void verifyContactsLinkTest() throws InterruptedException 
 {
	 Thread.sleep(3000);
	 contactspage =homepage.contactLink();
 }
   
 @AfterMethod
 public void logout() throws InterruptedException 
 {
	 Thread.sleep(3000);
	 driver.quit();
 }
 
 
 
 
 
 
 
 
 
 
 
 
}
