package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium3 {

	public static void main(String[] args) throws InterruptedException {
	//	System.setProperty("webdriver.chrome.dirver","C:\\Users\\shrid\\Downloads\\chromedriver_win32\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shrid\\Downloads\\chromedriver_win32\\chromedriver.exe");

         WebDriver driver=new ChromeDriver();
         driver.manage().window().maximize();
         driver.get("https://www.facebook.com/");	
        // WebElement emailBox=  driver.findElement(By.tagName("input"));
	  // emailBox.sendKeys("abc@gmail.com");
	  WebElement emailBox = driver.findElement(By.id("email"));
	  emailBox.sendKeys("abc@gmail.com");
	  Thread.sleep(3000);
	  // WebElement emailBox= driver.findElement(By.name("email"));
	  // emailBox.sendKeys("abc@gmail.com");
	 //  Thread.sleep(3000);
       //  WebElement emailBox= driver.findElement(By.className("inputtext _55r1 _6luy"));
        // emailBox.sendKeys("abc@gmail.com");
    	  // Thread.sleep(3000)BY
	WebElement passBox=  driver.findElement(By.id("pass"));
	passBox.sendKeys("12345");
	Thread.sleep(2000);
	//WebElement button=driver.findElement(By.name("login"));
	//button.click();
	//Thread.sleep(2000);
	//WebElement link=driver.findElement(By.partialLinkText("password?"));
	//link.click();
	//WebElement contactclick=driver.findElement(By.linkText("forgotten password?"));
     //contactclick.click(); 
	
	//WebElement button=driver.findElement(By.cssSelector("button[type='submit']"));
	//button.click();
		WebElement button=driver.findElement(By.xpath("//button[@name='login'or @id='1']"));
		button.click();
	
	}

}
