package com.qa.freeCRM.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.CRM.qa.Base.TestBase;
import com.qa.pages.freeCRMTest.HomePage;
import com.qa.pages.freeCRMTest.LoginPage;

public class LoginPageTest extends TestBase
{
	LoginPage loginpage;
	HomePage homepage;
	
	public LoginPageTest() 
	{
		super(); 
	}
	
	
	
 @BeforeMethod
 public void setUp() 
 {
	 intialisation(); 
	 loginpage = new LoginPage();
 }
 
 
 @Test(priority=0)
 public void titleTest() 
 {
	 String title = loginpage.validateloginPageTitle();
	 Assert.assertEquals(title, "Cogmento CRM");
 }
 
 @Test(priority=1)
 public void loginTest() 
 {
	 homepage = loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
 }
 
 
@AfterMethod
public void logout() 
{
	driver.quit();
}
	
	
}
