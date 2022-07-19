package com.Parameter;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;


public class DownloadfileWithFirefox {

	public static void main(String[] args) throws InterruptedException {
     System.setProperty("webdriver.gecko.driver", "C:\\Users\\shrid\\eclipse-workspace\\Selenium project\\Driver\\geckodriver.exe");
     String path=System.getProperty("user.dir")+"\\Downlods\\";
     //for firefox
     FirefoxProfile profile=new FirefoxProfile();
     profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/x-zip-compressed");
     profile.setPreference("browser.download.folderList", 2);
     profile.setPreference("browser.download.dir", path);
      
     FirefoxOptions options=new FirefoxOptions();
     options.setProfile(profile);
     
    // WebDriverManager.firefoxdriver().setup();
     WebDriver driver=new FirefoxDriver(options);
     
     driver.manage().window().maximize();
     driver.get("https://chromedriver.storage.googleapis.com/index.html?path=104.0.5112.29/");
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     
     driver.findElement(By.xpath("//a[text()='chromedriver_win32.zip']")).click();
     Thread.sleep(5000);
     driver.close();
     
     
	}

}
