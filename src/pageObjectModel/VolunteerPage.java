package pageObjectModel;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class VolunteerPage {
   WebDriver driver;
   ModelClass1 m1;
   
   @BeforeClass
   public void initObject() {
	    m1=new ModelClass1(driver);
   }
	
	@BeforeSuite
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shrid\\eclipse-workspace\\Selenium project\\Driver\\chromedriver1.exe");
	   driver=new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://fs2.formsite.com/meherpavan/form2/index.html?1537702596407");
	
	
	}
	@Test
  public void Signup() {
		String actTitile=driver.getTitle();
		Assert.assertEquals(actTitile, "Selenium Practice Form","title is matched");
		m1.Entercred1("shrikant", "dagade", 9096164646L, "india", "pune", "dagadeshriknt12@gmail.com");
		m1.timeselect("Morning");
		m1.clicksubmitbtn();
		
  }
	@AfterSuite
	public void teardown() {
		driver.close();
	}
}
