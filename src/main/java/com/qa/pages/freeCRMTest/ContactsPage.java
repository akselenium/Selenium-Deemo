package com.qa.pages.freeCRMTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.CRM.qa.Base.TestBase;

public class ContactsPage extends TestBase 
 {
  @FindBy(xpath="//div[@class='ui header item mb5 light-black']")
  WebElement contactLogo;
  
  @FindBy(xpath="//div[ @id='dashboard-toolbar']/child::div[2]/child::div/a")
  WebElement newContactTab;
  
  @FindBy(xpath="//input[@name='first_name']")
  WebElement firstName;
  
  @FindBy(xpath="//input[@name='last_name']")
  WebElement lastName;
  
  @FindBy(xpath="//input[@placeholder='Email address']")
  WebElement emailName;
  
  @FindBy(xpath="//*[text()='Save']")
  WebElement saveBtn;
  

  
  public ContactsPage() 
  {
	  PageFactory.initElements(driver,this);
  }
  
  
  public boolean verifyContactLogo() 
  {
	  return contactLogo.isDisplayed();  
  }
  
  public void selectContactsByName(String name) 
  {
	  driver.findElement(By.xpath("//td[text()='"+name+"']/preceding-sibling::td")).click();
  }
  
  public void clickOnNewContact() throws InterruptedException 
  {
	  newContactTab.click();
	  Thread.sleep(10000);
  }
  
  public void createNewContact(String fName,String lName,String Email) 
  {
	  firstName.sendKeys(fName);
	  lastName.sendKeys(lName);
	  emailName.sendKeys(Email);
	  saveBtn.click();
  }
  
  
  
  
  
 }
