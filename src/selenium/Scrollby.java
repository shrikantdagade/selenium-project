package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scrollby {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shrid\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
       driver.manage().window().maximize();
       driver.get("https://vctcpune.com/selenium/practice.html");
       JavascriptExecutor js= (JavascriptExecutor )driver;
       js.executeScript("window.scrollBy(0,600)");
       
     //step-5 click on Alert button
       driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
      
       Thread.sleep(3000);
     //step-5- a handle alert
       driver.switchTo().alert().accept();
     //step-6 click on confirm button
     //  driver.findElement(By.xpath("//input[@id='confirmbtn']")).click();
    //   driver.switchTo().alert().dismiss();
       
       driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Professor");
       driver.findElement(By.xpath("//input[@id='confirmbtn']")).click();
       String almessage =driver.switchTo().alert().getText();
       System.out.println(almessage);
       if(almessage.contains("Professor")) {
    	   Thread.sleep(2000);
    	   driver.switchTo().alert().accept();
    	   System.out.println("pass");
    	   
       }else {
    	   Thread.sleep(2000);
    	   driver.switchTo().alert().dismiss();
    	   System.out.println("fail");
       }
	}
	}    
       