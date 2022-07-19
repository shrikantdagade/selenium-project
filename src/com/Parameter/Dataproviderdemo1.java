package com.Parameter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.formula.atp.Switch;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(TestNG.ListenerClass.class)
public class Dataproviderdemo1 {
 
	public WebDriver driver;
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shrid\\eclipse-workspace\\Selenium project\\Driver\\chromedriver1.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html?classic=true");	
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}	
	
   @Test(dataProvider = "FDcalculate")
  public void calculateFD(long principle,long rateofint,long period,String frequency ,long expmaturityvalue) throws InterruptedException {
	   driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(String.valueOf(principle));
	   driver.findElement(By.xpath("//input[@id='interest']")).sendKeys(String.valueOf(rateofint));
	   driver.findElement(By.xpath("//input[@id='tenure']")).sendKeys(String.valueOf(period));
	   Select tenuredd=new Select(driver.findElement(By.xpath("//select[@id='tenurePeriod']")));
	   tenuredd.selectByVisibleText("year(s)");
	   
	   Select freq=new Select(driver.findElement(By.id("frequency")));
	   freq.selectByVisibleText(frequency);
	   
	   driver.findElement(By.xpath("//img[@src='https://images.moneycontrol.com/images/mf_revamp/btn_calcutate.gif']")).click();
	   String actmaturityvalue= driver.findElement(By.xpath("//span[@id='resp_matval']")).getText();
	   
     	   if(Double.parseDouble(actmaturityvalue)==expmaturityvalue) {
     		  System.out.println("Test case passed");
     	   }
     	   else {
     		  System.out.println("Test case failed");
     	   }
     	  Thread.sleep(5000);
     	 driver.findElement(By.xpath("//img[@class='PL5']")).click();
	      
  }
   
   @DataProvider(name = "FDcalculate")
   public Object[][] getdata() throws IOException{
	   Object[][] value=readData();
	   return value; 
	   
   }
   public Object[][] readData() throws IOException   {
	   
	 Object[][]data=null;
	 String path= System.getProperty("user.dir")+"\\readfile.xlsx";
	 File file=new File(path);
	 FileInputStream fis=new FileInputStream(file);
	 XSSFWorkbook wb=new XSSFWorkbook(fis);
	 XSSFSheet sheet= wb.getSheetAt(0);
	  int lastrow =sheet.getLastRowNum();
	 int lastcell= sheet.getRow(0).getLastCellNum();
	 data=new Object[lastrow][lastcell];
	 for(int r=1;r<=lastrow;r++) {
		 XSSFRow row=sheet.getRow(r);
		 
		 for(int c=0;c<lastcell;c++) {
			XSSFCell cell= row.getCell(c);
			
			switch(cell.getCellType()) {
			
			case NUMERIC:data[r-1][c]=(long)cell.getNumericCellValue();
				break;
			case STRING:data[r-1][c]=cell.getStringCellValue();
				break;
		
			default:  data[r-1][c]=null;
				break;
			
			}			
		 }
	 }
    wb.close();	   
	return data;
	
}
   
   
   @AfterTest
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}
   
   
   
   
   
}
