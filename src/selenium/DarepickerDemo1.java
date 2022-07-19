package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DarepickerDemo1 {

	public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\shrid\\eclipse-workspace\\Selenium project\\Driver\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//input[@id='dob']")).click();
	Select month=new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
	month.selectByVisibleText("Jul");
	Select year=new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")));
	year.selectByVisibleText("1994");
	List<WebElement> alldates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//td//a"));
	for(WebElement e:alldates)		{
		String dates=e.getText();
		if(dates.equals("16")) {
			e.click();
			break;
		}
	}
	
	

	}

}
