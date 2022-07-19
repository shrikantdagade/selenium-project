package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Goibocalender {
          
	public static void main(String[] args) {
		 String monyear="november 2022";
         String date="21";
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shrid\\eclipse-workspace\\Selenium project\\Driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.goibibo.com/flights/?utm_source=google&utm_medium=cpc&utm_campaign=DF-Brand-EM&utm_adgroup=Only%20Goibibo&utm_term=!SEM!DF!G!Brand!RSA!108599293!6504095653!602838584772!e!goibibo!c!&gclid=CjwKCAjwwdWVBhA4EiwAjcYJEAgJwKtQ2UF5-QP_-FF-AxwR5w4hYZh8bx6hoRriY3_yLVUU-d3UCBoC6DgQAvD_BwE");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//span[@class='sc-kgflAQ ezEjxY fswDownArrow']")).click();
		while(true) {
			WebElement monthyear =driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[2]/div/div[1]/div[3]/div[2]/div[2]/div/div/div[2]/div[1]/div[1]"));
			String namemonthyr=monthyear.getText();
			if (namemonthyr.equalsIgnoreCase(monyear)) {
				break;
			}
			else {
				driver.findElement(By.xpath("//span[@aria-label=\"Next Month\"]")).click();
		    	
		    }
				
			}
		 List <WebElement> days=driver.findElements(By.xpath("//div[@class='DayPicker-Body']//div//p"));
		  for(WebElement daylist: days)
		  {
			  String day=daylist.getText();
			  if(day.equals(date)) {
				  daylist.click();
				  break;
				  }
		  }
		  driver.findElement(By.xpath("//span[@class='fswTrvl__done']")).click();
			  
		}
	}


