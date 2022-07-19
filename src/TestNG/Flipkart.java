package TestNG;

import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Flipkart {
  WebDriver driver;

@BeforeTest
public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\shrid\\eclipse-workspace\\Selenium project\\Driver\\chromedriver1.exe");
      driver=new ChromeDriver();
      driver.get("https://www.flipkart.com/");
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  
	
}
	
	@Test
	public void Loginpage() throws InterruptedException {
		
	 // driver.findElement(By.xpath("//a[@class='_1_3w1N']")).click();
	 // driver.switchTo().alert().accept();
	  WebElement logElement= driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input"));
	  logElement.clear();
	  logElement.sendKeys("9096169649");
	  
	  WebElement passElement=driver.findElement(By.xpath("//input[@type='password']"));
	  passElement.clear();
	  passElement.sendKeys("India2020");
	  
	  driver.findElement(By.xpath("//button[@class='_2KpZ6l _2HKlqd _3AWRsL']")).click();
	  Thread.sleep(3000);
	  
	}	  
	  
	@Test
	public void Searchvalidate() throws InterruptedException {
		
		driver.findElement(By.className("_3704LK")).sendKeys("realme");
		driver.findElement(By.className("L0Z3Pu")).click();
		Thread.sleep(3000);
	}  
		@Test
		public void validatenextTab() {
		 List<WebElement>opentabElements= driver.findElements(By.xpath("(//a[@class='_1fQZEK'])"));
		 int no=opentabElements.size();
		 for(int i=1;i<=no;i++) {
			 if(i<=3) {
				 String openagain=Keys.chord(Keys.CONTROL,Keys.ENTER);
				 opentabElements.get(i).sendKeys(openagain);
			         }
			 
		 }
		 
	  
	  
	  
	  
 
}
	@AfterTest
	public void afterTest() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}
}