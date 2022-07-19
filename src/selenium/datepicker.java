package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class datepicker {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shrid\\eclipse-workspace\\Selenium project\\Driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
	
	    driver.get("https://jqueryui.com/datepicker/");
		
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		while(true) {
			WebElement monthyear=driver.findElement(By.xpath("//div[@class='ui-datepicker-title']"));
		    String calmonthyear=monthyear.getText();
		    if(calmonthyear.equals("September 2022")) {
		    	driver.findElement(By.xpath("//table/tbody/tr[2]/td[5]")).click();
		    	break;
		    }
		    else {
		    	driver.findElement(By.cssSelector("a[title='Next']")).click();
		    }
			
		}
	

	}

}
