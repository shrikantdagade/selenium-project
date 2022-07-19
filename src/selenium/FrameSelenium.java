package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameSelenium {

	public static void main(String[] args) {
	  
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shrid\\eclipse-workspace\\Selenium project\\Driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
		//switch to frame1
		driver.switchTo().frame(0);//name of the frame
		
		driver.findElement(By.cssSelector("a[href='org/openqa/selenium/package-frame.html']")).click();
		
		driver.switchTo().defaultContent();//go back to main page
		//switch to 2 frame
		driver.switchTo().frame(1);
		driver.findElement(By.xpath("//span[contains(text(),'TakesScreenshot')]")).click();
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(2);
		driver.findElement(By.xpath("/html/body/header/nav/div[1]/div[1]/ul/li[5]/a")).click();
		
	}

}
