package TestNG;

import java.sql.Driver;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ImplicitWait {

	WebDriver driver;

	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\shrid\\eclipse-workspace\\Selenium project\\Driver\\chromedriver1.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");

	}

	@Test
	public void alerthandle() {
		driver.findElement(By.id("alert")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		// driver.findElement(By.id("populate-text")).click();

	}

	@Test
	public void testcase2() {
		driver.findElement(By.id("display-other-button")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hidden")));
		// WebElement element=driver.findElement(By.id("hidden"));
		String text = element.getText();
		System.out.println(text);

		Assert.assertEquals(text, "Enabled");

	}

	@Test
	public void testcase3() {
		driver.findElement(By.id("enable-button")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("disable")));
		System.out.println(element.getText());
		Assert.assertEquals(element.getText(), "Button");

	}

	@AfterTest
	public void teardown() throws InterruptedException {
		Thread.sleep(7000);
		driver.quit();
	}
}
