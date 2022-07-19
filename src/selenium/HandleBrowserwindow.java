package selenium;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleBrowserwindow {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shrid\\eclipse-workspace\\Selenium project\\Driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/r.php?locale=en_GB&display=page");
		String window1=driver.getWindowHandle();
		System.out.println(window1);
		driver.findElement(By.cssSelector("a[href=\"https://www.oculus.com/\"]")).click();
		Set<String>windowsid=driver.getWindowHandles();
		//1 method iterator()
		Iterator<String>ids=windowsid.iterator();
	/*	String ids1=ids.next();
		String ids2=ids.next();
		
		System.out.println(ids1);
		System.out.println(ids2);
		//how to use windowsid for switching
		
		driver.switchTo().window(ids1);//title of window 1
		String titlewindow1=driver.getTitle();
		System.out.println(titlewindow1);
		//2 window title
		driver.switchTo().window(ids2);
		String titlewindow2=driver.getTitle();
		System.out.println(titlewindow2);*/
		
		//for each loop also for switch multiple windows
		
		for (String getids:windowsid) {
			System.out.println(getids);
			driver.switchTo().window(getids);
			String title1=driver.getTitle();
			System.out.println(title1);
			if(title1.equals("Oculus VR Headsets, Games & Equipment - Meta Quest | Meta Store"))
			{
				driver.close();
			}
			
		}
		
		
		
	}

}
