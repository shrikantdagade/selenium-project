package TestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class grupsclass {
 WebDriver driver;
	@BeforeTest
	public void setup() {
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\shrid\\eclipse-workspace\\Selenium project\\Driver\\chromedriver1.exe");
		  driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		  driver.get("https://opensource-demo.orangehrmlive.com/");	
	}
	@Test(groups = "sanity")
  public void f() {
		
		 WebElement logoElement=driver.findElement(By.xpath("//*[@id=\"divLogo\"]/img"));
			
		  Assert.assertTrue(logoElement.isDisplayed());
  }
	@Test(groups = "sanity")
	public void s() {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		  driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		  driver.findElement(By.id("btnLogin")).sendKeys(Keys.ENTER);
		  Assert.assertEquals(driver.getTitle(),"OrangeHRM");
	}
	@AfterTest
	public void teardown() {
		driver.close();
	}
}
