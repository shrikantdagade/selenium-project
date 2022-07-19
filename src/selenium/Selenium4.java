package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium4 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shrid\\Downloads\\chromedriver_win32\\chromedriver.exe");
         WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        List<WebElement> links=  driver.findElements(By.tagName("a"));
        int no=  links.size();
        System.out.println(no);
        
        for(WebElement ele:links) {
        String name=	ele.getText();
        System.out.println(name);
       if(name.equals("Log In"))
        ele.click();
        }
	}

}
