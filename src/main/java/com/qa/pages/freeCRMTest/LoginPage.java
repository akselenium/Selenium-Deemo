package com.qa.pages.freeCRMTest;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.CRM.qa.Base.TestBase;

public class LoginPage extends TestBase
{
  @FindBy(name="email")
  WebElement username;
  
  @FindBy(name="password")
  WebElement pwd;
  
  @FindBy(xpath ="//div[text()='Login']")
  WebElement LoginBtn;
  
  
  public LoginPage()
  {
	  PageFactory.initElements(driver, this);
	  
  }
  
  public String validateloginPageTitle()
  {
	  return driver.getTitle();
  }
  
  public HomePage login(String un,String pw)
  {
	  username.sendKeys(un);
	  pwd.sendKeys(pw);
	  LoginBtn.click();
	  
	  return new HomePage();
  }
  

}
