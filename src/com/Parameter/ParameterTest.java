package com.Parameter;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {
	WebDriver driver;
	
	@Parameters({"URL","UserName","browser",})
  @Test
  public void orangehrmTest(String URL,String UserName,String browser){
		if(browser.equals("chrome")) {
	  
	         System.setProperty("webdriver.chrome.driver", "C:\\Users\\shrid\\eclipse-workspace\\Selenium project\\Driver\\chromedriver1.exe");
              driver=new ChromeDriver();}
		else {
			  System.setProperty("webdriver.gecko.driver", "C:\\Users\\shrid\\eclipse-workspace\\Selenium project\\Driver\\geckodriver.exe");
			  driver=new FirefoxDriver();
		}
      driver.get(URL);
		
      
      driver.findElement(By.id("txtUsername")).sendKeys(UserName);
      driver.findElement(By.id("txtPassword")).sendKeys("admin123");
      driver.findElement(By.id("btnLogin")).click();
      
      
      
	  
	  
	  
  }
}
