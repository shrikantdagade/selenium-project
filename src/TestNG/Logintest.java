package TestNG;

import org.testng.annotations.Test;



import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class Logintest {
	WebDriver driver;
  
	@Parameters("browser")
  @BeforeTest
  public void beforeTest(String browserName) {	 
	if(browserName.equals("chrome")) {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\shrid\\eclipse-workspace\\Selenium project\\Driver\\chromedriver1.exe");
      driver=new ChromeDriver();
      driver.get("https://opensource-demo.orangehrmlive.com/");
      driver.manage().window().maximize();
  
  }else {
	  if(browserName.equals("firefox")){
	  System.setProperty("webdriver.gecko.driver", "C:\\Users\\shrid\\eclipse-workspace\\Selenium project\\Driver\\geckodriver.exe");
	  driver=new FirefoxDriver();
      driver.get("https://opensource-demo.orangehrmlive.com/");
      driver.manage().window().maximize();
	  
  }}}
  @Test
  public void logiTest() {	  	  
	  driver.findElement(By.id("txtUsername")).sendKeys("Admin");
	  driver.findElement(By.id("txtPassword")).sendKeys("admin123");
	  driver.findElement(By.id("btnLogin")).click();
	 
  }
  @Test
  public void VerifyTitlepage( ) {
	  String title=driver.getTitle();
	  System.out.println(title);	
	  Assert.assertEquals(title,"OrangeHRM");
	  
	 
  }
  

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
