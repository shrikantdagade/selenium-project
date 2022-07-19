package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandleDropDown {

	public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\shrid\\eclipse-workspace\\Selenium project\\Driver\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
    driver.get("https://www.opencart.com/index.php?route=account/register");
    WebElement dropdown=driver.findElement(By.xpath("//select[@name='country_id']"));
    Select countrydrop=new Select(dropdown);
    //countrydrop.selectByVisibleText("Bermuda");
 //   countrydrop.selectByValue("99");
 //   countrydrop.selectByIndex(21);
  
    //without usin select method
    
    List<WebElement>Alloption=countrydrop.getOptions();   
    System.out.println(Alloption.size());
  
    
    for(WebElement option:Alloption) {
    	String optionName=option.getText();
    	System.out.println(optionName);
    	if(optionName.equalsIgnoreCase("cuba")) {
    		option.click();
    		break;
    	}
    }
    
    
    
	}

}
