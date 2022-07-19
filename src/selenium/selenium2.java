package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class selenium2 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shrid\\Downloads\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/login/");
		String actualURL=driver.getCurrentUrl();
		System.out.println(actualURL);
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		String expectedTitle="Log in to facebook";
		if(actualTitle.equalsIgnoreCase(expectedTitle)) {
			System.out.println("matching the title");
		}else {
			System.out.println("unmatched the Title");
		}
		String expectedURL="https://www.Facebook.com/login/";
		if(expectedURL.equalsIgnoreCase(actualURL)) {
			System.out.println("matching the URL");
		}else{
			System.out.println("unmatched the URL");
		}
		
		driver.close();
	}

}
