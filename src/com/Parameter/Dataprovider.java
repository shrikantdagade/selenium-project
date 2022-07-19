package com.Parameter;
//comment line
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

public class Dataprovider {
	WebDriver driver;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shrid\\eclipse-workspace\\Selenium project\\Driver\\chromedriver1.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://fs2.formsite.com/meherpavan/form2/index.html?1537702596407");

	}  
	@Test(dataProvider = "TestData")
	public void signupPage(String FirstName,String LastName,long Phone,String Country,String City, String Email,String day,String time ){
		driver.findElement(By.id("RESULT_TextField-1")).sendKeys(FirstName);
		driver.findElement(By.id("RESULT_TextField-2")).sendKeys(LastName);
		driver.findElement(By.id("RESULT_TextField-3")).sendKeys(String.valueOf(Phone));
		driver.findElement(By.id("RESULT_TextField-4")).sendKeys(Country);
		driver.findElement(By.id("RESULT_TextField-5")).sendKeys(City);
		driver.findElement(By.id("RESULT_TextField-6")).sendKeys(Email);

		//driver.findElement(By.xpath("//input[@id='RESULT_RadioButton-7_0']")).click();

		List<WebElement> daysElements= driver.findElements(By.xpath("//div[@id='q15']//table[@class='inline_grid choices']/tbody/tr"));
		for(WebElement days:daysElements) {
			String daylist=  days.getText();
			if(daylist.equals(day)) {
				days.click();
			}
		}
		Select act =new Select(driver.findElement(By.xpath("//select[@id='RESULT_RadioButton-9']")));
		act.selectByVisibleText(time);

		driver.findElement(By.xpath("//input[@id='FSsubmit']")).click();


		driver.navigate().back();
		driver.navigate().refresh();
	}

	@DataProvider(name="TestData")
	public Object[][] getdata() throws IOException{
		Object[][] valueStrings=readData();
		return valueStrings;
	}

	public Object[][] readData() throws IOException {
        Object  [][]data  =null;
		String path=System.getProperty("user.dir")+"\\TestData.xlsx";
		File file=new File(path);
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet= wb.getSheetAt(0);

		int lastrow= sheet.getLastRowNum();

		int lastcell=sheet.getRow(0).getLastCellNum();
		data=new Object[lastrow][lastcell];
		for(int r=1;r<=lastrow;r++) {
			XSSFRow row= sheet.getRow(r);
			for(int c=0;c<lastcell;c++) {
                 XSSFCell cell=row.getCell(c);
				
                switch (cell.getCellType()) {
				case STRING:  data[r-1][c]=cell.getStringCellValue();
				break;

				case NUMERIC: data[r-1][c]=(long)cell.getNumericCellValue();
					break;
				 default:data[r-1][c]=null;
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
