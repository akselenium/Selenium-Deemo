package com.CRM.qa.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.FreeCRM.Util.Util;

public class TestBase 
{
public static WebDriver driver;
public static Properties prop;


//create a constructor
   public TestBase() 
    {
	   try
	   {
	  prop = new Properties(); 
	  FileInputStream fip = new FileInputStream("D:\\Selenium\\seleniumproject\\freeCRMTest\\src\\main\\java\\com\\" +
	                                              "qa\\FreeCRM\\config\\config.properties");
	  prop.load(fip);
	   }
	   catch(FileNotFoundException e) 
	   {
		  e.printStackTrace(); 
	   }
	   catch(IOException e) 
	   {
		  e.printStackTrace(); 
	   }
	}

	 public static void intialisation() 
	 {
		 String browser_name = prop.getProperty("browser");
		 if(browser_name.equals("Firefox"))
		 {
			 System.setProperty("webdriver.gecko.driver", "C:\\Users\\SAMSUNG\\Desktop\\Selenium\\geckodriver.exe");
		     driver=new FirefoxDriver();
		 }
		 else if(browser_name.equals("Chrome"))
		 {
			 System.setProperty("webdriver.chrome.driver", "C:\\Users\\SAMSUNG\\Desktop\\Selenium\\romechdriver.exe");
		     WebDriver driver=new ChromeDriver();
		 }
		 
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().pageLoadTimeout(Util.page_load_timeout,TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(Util.implicity_timeout,TimeUnit.SECONDS);
		 
		 driver.get(prop.getProperty("url"));
	 }
}
