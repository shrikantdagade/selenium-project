package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragandDropdemo1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shrid\\eclipse-workspace\\Selenium project\\Driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/#Accepted%20Elements");
		driver.manage().window().maximize();
		WebElement frame1=driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']"));
		driver.switchTo().frame(frame1);
		//drag element list
		WebElement item1=driver.findElement(By.xpath("//li[1]"));
		WebElement item2=driver.findElement(By.xpath("//li[2]"));
		WebElement item3=driver.findElement(By.xpath("//li[3]"));
		WebElement item4=driver.findElement(By.xpath("//li[4]"));
		//to drop element
		WebElement box=driver.findElement(By.xpath("//div[@id='trash']"));
		
		Actions act=new Actions(driver);
		act.dragAndDrop(item1, box).perform();
		act.dragAndDrop(item2, box).perform();
		act.dragAndDrop(item3, box).perform();
		act.dragAndDrop(item4, box).perform();
	}
}
