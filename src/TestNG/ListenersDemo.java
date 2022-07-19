package TestNG;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestNG.ListenerClass.class)
public class ListenersDemo {
      public static WebDriver driver;
	
	@BeforeClass
      public void setup() {
    	  
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shrid\\eclipse-workspace\\Selenium project\\Driver\\chromedriver1.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
      } 
          
	@Test(priority = 2)
  public void VerifyTitle() {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).sendKeys(Keys.ENTER);
	   
	    System.out.println("verify the title");
	   Assert.assertEquals(driver.getTitle(), "OrangeHRM1");
	    
  }
	@Test(priority = 1)
	  public void VerifyURL() {
		   
		  System.out.println("verify the URL");
		  Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/");
		    
	  }
	
	@Test(priority=3)
	public void testSkipped() {
		System.out.println("skipped test case");
		throw new SkipException("SKIP EXCEPTION TTHROWN....");
		
	}
	
	
	
}
