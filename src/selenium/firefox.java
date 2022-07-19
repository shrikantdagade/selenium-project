package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class firefox {

	public static void main(String[] args) {
	System.setProperty("webdriver.gecko.driver","C:\\Users\\shrid\\eclipse-workspace\\Selenium project\\Driver\\geckodriver.exe");
     WebDriver driver=new FirefoxDriver();
	//System.setProperty("webdriver.chrome.driver","C:\\Users\\shrid\\Downloads\\chromedriver_win32\\chromedriver.exe");
	//WebDriver driver=new ChromeDriver();
	 driver.get("https://www.facebook.com/");
	 driver.findElement(By.xpath("//button[@name='login']")).click();
	  
	}
	
	
	
	
	
	
	

}
