package TestNG;

import static org.testng.Assert.fail;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GroupAtribute {
	WebDriver driver;
	@BeforeClass(alwaysRun = true)
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shrid\\eclipse-workspace\\Selenium project\\Driver\\chromedriver1.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.selenium.dev/");


	}	
	@Test(groups = "smoke")
	public void Testcase1() {
		driver.findElement(By.xpath("//li[@class='nav-item dropdown']//a[@id='navbarDropdown']")).click();
		WebElement aboutlink =   driver.findElement(By.xpath("//a[@href='/about']"));
		aboutlink.click();
		String title= driver.getTitle();
		System.out.println("my current page title is:"+title);
		Assert.assertEquals(title, "About Selenium | Selenium");

	}

	@Test(groups = "smoke")
	public void testcase2() throws InterruptedException {

		driver.findElement(By.xpath("//a[@href='/downloads']")).click();
           Thread.sleep(5000);
		WebElement element=driver.findElement(By.xpath("//a[normalize-space()='MVNRepository']"));
		//JavascriptExecutor je=(JavascriptExecutor)driver;

		//je.executeScript("arguments[0].scrollIntoView(true)", element);
		element.click();
		
		WebElement element2=driver.findElement(By.linkText("Selenium Java"));
		Assert.assertTrue(element2.isDisplayed());
		String  dependancy=element2.getText();

		System.out.println("copied text from selenium java:"+ dependancy);
		driver.navigate().back();


	}

	@Test(priority = 3,groups = "sanity")
	public void verifySupport() {
		driver.findElement(By.xpath("//span[normalize-space()='Support']")).click();
		WebElement element3 = driver.findElement(By.linkText("Bug Tracker"));
		Assert.assertTrue(element3.isEnabled());
		String title1 = driver.getTitle();
		System.out.println("the current page title:"+title1);
	}
	@Test(priority = 4,groups = "sanity")
	public void verifyDocumentation() {
		driver.findElement(By.xpath("//*[@id=\"main_navbar\"]/ul/li[4]")).click();
		WebElement element4=driver.findElement(By.xpath("(//div[@class='code-toolbar'])[1]"));

		Assert.assertTrue(element4.isDisplayed());
		System.out.println("the current page title:"+driver.getTitle());
	}

	@Test(priority = 5,groups = "sanity")
	public void VerifyProjects() throws InterruptedException {
		driver.findElement(By.xpath("//a[@href='/projects']")).click();
		driver.findElement(By.linkText("W3C Recommendation!")).click();
		WebElement element5=driver.findElement(By.xpath("//a[@class='u-url']"));
		Assert.assertTrue(element5.isEnabled());
		String link= element5.getText();
		System.out.println("available link is:"+link);
		driver.navigate().back();
		Thread.sleep(5000);
	}

	@Test(groups = {"regression","smoke"})
	public void logoTest() {
		WebElement logoElement=driver.findElement(By.xpath("//div[@class='row justify-content-around pt-4 pb-5 px-5']/div[1]"));
		Assert.assertTrue(logoElement.isDisplayed());
	}

	@AfterClass(alwaysRun = true)
	public void teardown() {
		driver.close();
	}










}
