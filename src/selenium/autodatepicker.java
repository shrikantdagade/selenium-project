package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class autodatepicker {
	
	public static void selectdate(String nameyear ,String i) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shrid\\eclipse-workspace\\Selenium project\\Driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
	
	    driver.get("https://jqueryui.com/datepicker/");
	    driver.switchTo().frame(0);//switch to frame
	    //find the date picker element
	    driver.findElement(By.xpath("//input[@id='datepicker']")).click();
	    while(true) {
	    	WebElement monthyear=driver.findElement(By.cssSelector("div.ui-datepicker-title"));
	    	String name=monthyear.getText();
	    	if(name.equals(nameyear)) {
	    	List<WebElement> days=	driver.findElements(By.xpath("//table/tbody/tr/td/a"));
	    	  for(WebElement e:days) {
	    	   String dayslist=e.getText();
	    	   if(dayslist.equals(i)) {
	    		   e.click();
	    		   break;
	    		   }	    	
	    	}
	    	 break;
	    	  
	    	}
	    	else {
	    		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
	    	}
	    }
		
	}
       
	public static void main(String[] args) {
		
		selectdate("December 2023", "21");

	}

}
