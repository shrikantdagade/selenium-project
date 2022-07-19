package selenium;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ExcelsheetHandledemo {

	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shrid\\eclipse-workspace\\Selenium project\\Driver\\chromedriver1.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html?classic=true");
		
		 JavascriptExecutor js= (JavascriptExecutor )driver;
	     js.executeScript("window.scrollBy(0,400)");
	       
		//getting data from excel sheet
		FileInputStream file=new FileInputStream(".\\Datafile\\excel2.xlsx");
		
		//get to workbook instance for xlsx file
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		
		//get sheet from the workbook
		XSSFSheet sheet=workbook.getSheet("sheet1");
		int rowcount=sheet.getLastRowNum();
		 
		for(int row=1;row<=rowcount;row++) {
			XSSFRow current_row=sheet.getRow(row);
			
			XSSFCell principle=current_row.getCell(0);
			int prince=(int) principle.getNumericCellValue();
			//or int prince=(int)current_row.getCell(0).getNumericCellValue();
			
			XSSFCell roi=current_row.getCell(1);
			int rateofinterest=(int) roi.getNumericCellValue();
			
			XSSFCell period=current_row.getCell(2);
		    int per=(int) period.getNumericCellValue();
		    
		   XSSFCell frquency= current_row.getCell(3);
		   String freq=frquency.getStringCellValue();
		   
		   XSSFCell maturityvalue=current_row.getCell(4);
		   int Exp_mvalue=(int) maturityvalue.getNumericCellValue();
		   
		   driver.findElement(By.id("principal")).sendKeys(String.valueOf(prince));
		   driver.findElement(By.id("interest")).sendKeys(String.valueOf(rateofinterest));
		   driver.findElement(By.id("tenure")).sendKeys(String.valueOf(per));
		   
		   Select perioddropdowm=new Select(driver.findElement(By.id("tenurePeriod")));
		   perioddropdowm.selectByVisibleText("year(s)");
		   
		   Select frequency=new Select(driver.findElement(By.id("frequency")));
		   frequency.selectByVisibleText(freq);
		   
		   driver.findElement(By.xpath("//img[@src='https://images.moneycontrol.com/images/mf_revamp/btn_calcutate.gif']")).click();
		 
		  String actual_mvalue= driver.findElement(By.xpath("//span[@id='resp_matval']")).getText();
		   if(Double.parseDouble(actual_mvalue)==Exp_mvalue)
		      {
			   System.out.println("Test case passed");
		      }
		   
		   else {
			   System.out.println("Test case failed");
		        }
		   Thread.sleep(5000);
		   driver.findElement(By.xpath("//img[@class='PL5']")).click();
		}
			driver.close();
	}

}
