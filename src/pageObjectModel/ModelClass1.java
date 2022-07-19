package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ModelClass1 {
	@FindBy(id="RESULT_TextField-1")
	private WebElement firstName;
	
	@FindBy(id="RESULT_TextField-2")
	private WebElement lastName;
	
	@FindBy(id="RESULT_TextField-3")
	private WebElement Phone;
	
	@FindBy(id="RESULT_TextField-4")
	 WebElement Country;
	
	@FindBy(id="RESULT_TextField-5")
     WebElement City;
	
	@FindBy(id="RESULT_TextField-6")
	private WebElement Email;
	
	@FindBy(id="RESULT_RadioButton-9")
	WebElement Time;
    
	@FindBy(xpath = "//input[@id='FSsubmit']")
	WebElement submitbtn;
	
	ModelClass1(WebDriver d){
		PageFactory.initElements(d, this);
		
	}

	public void Entercred1(String fname, String lname, long phone1, String country2, String city2, String email2) {
	  firstName.sendKeys(fname);
	  lastName.sendKeys(lname);
	  Phone.sendKeys(String.valueOf(phone1));
	  Country.sendKeys(country2);
	  City.sendKeys(city2);
	  Email.sendKeys(email2);
	  
  }
  public void timeselect(String time) {
	  Select st=new Select(Time);
	  st.selectByVisibleText(time);
	  
  }
  public void clicksubmitbtn() {
	  submitbtn.click();
  }

	// TODO Auto-generated method stub
	
}
 

