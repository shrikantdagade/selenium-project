package selenium;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot {

	public static void main(String[] args) throws IOException  {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shrid\\eclipse-workspace\\Selenium project\\Driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/login/");
		// take a screenshot
//		TakesScreenshot ts=(TakesScreenshot) driver;
//	    File shot=	ts.getScreenshotAs(OutputType.FILE);
//	    //saving the file our locatin
//	    File save=new File(".\\Screenshots\\facebook.png");
//	    FileHandler.copy(shot, save);
//	    System.out.println("screenshot capture");
//	    
	    //screenshot capture for section
	WebElement section=driver.findElement(By.xpath("//ul[@class='uiList pageFooterLinkList _509- _4ki _703 _6-i']"));
      File shot=  section.getScreenshotAs(OutputType.FILE);
      File save=new File(".\\Screenshots\\section.png");
     FileHandler.copy(shot, save);
	}

}

