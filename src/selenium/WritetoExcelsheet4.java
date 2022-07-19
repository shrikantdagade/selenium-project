package selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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

public class WritetoExcelsheet4 {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shrid\\eclipse-workspace\\Selenium project\\Driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://fs2.formsite.com/meherpavan/form2/index.html?1537702596407");
		driver.manage().window().maximize();
		
		File file =new File(".\\Datafile.\\excel5.xlsx");
        FileInputStream fis =new FileInputStream(file);
        
        XSSFWorkbook wb=new XSSFWorkbook(fis);
        XSSFSheet sheet=wb.getSheet("Sheet1");
        
        int lastrow=sheet.getLastRowNum();
        for(int r=1;r<=lastrow;r++) {
        	XSSFRow row=sheet.getRow(r);
        	
        	String FirstName=row.getCell(0).getStringCellValue();
        	String LastName=row.getCell(1).getStringCellValue();
        	int phone=(int) row.getCell(2).getNumericCellValue();
        	String Country=row.getCell(3).getStringCellValue();
        	String City=row.getCell(4).getStringCellValue();
        	String Email=row.getCell(5).getStringCellValue();
        	String Time=row.getCell(6).getStringCellValue();
        	
        	
        	driver.findElement(By.xpath("//input[@id='RESULT_TextField-1']")).sendKeys(FirstName);
        	driver.findElement(By.xpath("//input[@id='RESULT_TextField-2']")).sendKeys(LastName);
        	driver.findElement(By.xpath("//input[@id='RESULT_TextField-3']")).sendKeys(String.valueOf(phone));
        	driver.findElement(By.xpath("//input[@id='RESULT_TextField-4']")).sendKeys(Country);
        	driver.findElement(By.xpath("//input[@id='RESULT_TextField-5']")).sendKeys(City);
        	driver.findElement(By.xpath("//input[@id='RESULT_TextField-6']")).sendKeys(Email);
        	
        //	driver.findElement(By.xpath("//input[@id='RESULT_RadioButton-7_0']")).click();
        	
        	List<WebElement> daylist=driver.findElements(By.xpath("//input[@id='RESULT_RadioButton-7_0']"));
        	for(WebElement days:daylist) {
        		String checkbox=days.getAttribute("id");
        		if(checkbox.equals("RESULT_CheckBox-8_0")||checkbox.equals("RESULT_CheckBox-8_6"))
        		{
        			days.click();
        			break;
        		}             
        	} 
        	
        	Select contact=new Select(driver.findElement(By.xpath("//select[@id='RESULT_RadioButton-9']")));
        	contact.selectByVisibleText(Time);
        	
        	driver.findElement(By.xpath("//input[@id='FSsubmit']")).click();
        	
        	  XSSFRow row1=sheet.createRow(r);
        	  XSSFCell cell=row1.createCell(8);
        	  
        	 String message=driver.findElement(By.xpath("//div[@class='segment_header']")).getText();
        	  
        	 if(message.contains("An error has occurred")) {
        		 cell.setCellValue("PASS");
        	 }
        	 else {
        		 cell.setCellValue("FAIL");
        	 }
        	// Write the data back in the Excel file	
             FileOutputStream fos=new FileOutputStream(file);
             wb.write(fos);
             
             driver.navigate().back();
             driver.navigate().refresh();
        	
        	
        }
        wb.close();
        
	}

}
