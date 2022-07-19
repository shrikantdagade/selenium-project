package selenium;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle {

	public static void main(String[] args) throws InterruptedException {
     System.setProperty("webdriver.chrome.driver", "C:\\Users\\shrid\\eclipse-workspace\\Selenium project\\Driver\\chromedriver1.exe");
	 WebDriver driver=new ChromeDriver();	
	 driver.manage().window().maximize();
	 driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 String paranetwindow=driver.getWindowHandle();
	 System.out.println(paranetwindow);
		
	 driver.findElement(By.id("newWindowBtn")).click();
	  Set<String> handles =driver.getWindowHandles();
	  for(String windows:handles) {
		  System.out.println(windows);
		  if(!windows.equals(paranetwindow)) {
			  driver.switchTo().window(windows);
			  driver.findElement(By.id("firstName")).sendKeys("shrikant");
			  Thread.sleep(5000);
			  driver.close();
		  }
		  
	  }
	  driver.switchTo().window(paranetwindow);
	  driver.findElement(By.id("name")).sendKeys("dagade");
		
		
		
	}

}
