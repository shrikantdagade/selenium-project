package TestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Paralleltest {
	
	WebDriver driver;
	

	
	
  @Test(priority = 1)
  public void logoTest() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\shrid\\eclipse-workspace\\Selenium project\\Driver\\chromedriver1.exe");
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	  driver.get("https://opensource-demo.orangehrmlive.com/");	


	  WebElement logoElement=driver.findElement(By.xpath("//*[@id=\"divLogo\"]/img"));
	
	  Assert.assertTrue(logoElement.isDisplayed());
      Thread.sleep(2000);
	 
  }
  
  @Test(priority = 2)
  public void homepageTitle() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\shrid\\eclipse-workspace\\Selenium project\\Driver\\chromedriver1.exe");
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	  driver.get("https://opensource-demo.orangehrmlive.com/");	

	  driver.findElement(By.id("txtUsername")).sendKeys("Admin");
	  driver.findElement(By.id("txtPassword")).sendKeys("admin123");
	  driver.findElement(By.id("btnLogin")).sendKeys(Keys.ENTER);
	  Assert.assertEquals(driver.getTitle(),"OrangeHRM");
      Thread.sleep(2000);

	  
  }
  @AfterMethod
  public void tearDown() {
	  driver.quit();
  }
}
