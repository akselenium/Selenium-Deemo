package com.qa.pages.freeCRMTest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.CRM.qa.Base.TestBase;

public class HomePage extends TestBase 
{
  @FindBy(xpath="//span[@class='user-display']")
  WebElement loginnameCheck;
  
  @FindBy(xpath ="//div[@id='main-nav']//a[3]")
  WebElement contactsLink;
  
  @FindBy(xpath ="//span[text()='Deals']")
  WebElement dealsLink;
  
  
  public HomePage() 
  {
 	 PageFactory.initElements(driver, this);
  } 
  
  
  public String homePageTitle() 
  {
	  return driver.getTitle();
  }
   public ContactsPage contactLink() 
   {
	   contactsLink.click(); 
	   return new ContactsPage();
   }
   
   public DealsPage dealsLink() 
   {
	   dealsLink.click(); 
	   return new DealsPage();
   }
   
  
  
  
  
  
  
  
  
  
  
}


