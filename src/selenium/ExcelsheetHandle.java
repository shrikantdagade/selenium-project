package selenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ExcelsheetHandle {

	public static void main(String[] args) throws IOException  {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shrid\\eclipse-workspace\\Selenium project\\Driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://newtours.demoaut.com/");
		//getting data from excel sheet
		FileInputStream file=new FileInputStream(".\\Datafile\\excel2.xlsx");
		
		//get to workbook instance for xlsx file
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		
		//get sheet from the workbook
		XSSFSheet sheet=workbook.getSheet("sheet1");
		
		//get firxt row from the sheet
		int noofROW=sheet.getLastRowNum();
		System.out.println("no.of records in the excel sheet"+noofROW);
		
		for(int row=1;row<=noofROW;row++) {
			XSSFRow current_row=sheet.getRow(row);
			
			String First_Name=current_row.getCell(0).getStringCellValue();
			String Last_Name=current_row.getCell(1).getStringCellValue();
			String Phone=current_row.getCell(2).getStringCellValue();
			String Email=current_row.getCell(3).getStringCellValue();
			String Address=current_row.getCell(4).getStringCellValue();
			String City=current_row.getCell(5).getStringCellValue();
			String State=current_row.getCell(6).getStringCellValue();
			String PinCode=current_row.getCell(7).getStringCellValue();
			String Country=current_row.getCell(8).getStringCellValue();
			String UserName=current_row.getCell(9).getStringCellValue();
			String Password=current_row.getCell(10).getStringCellValue();
			
			driver.findElement(By.linkText("REGISTER")).click();
			
			//entering contact information
	 		driver.findElement(By.name("firstName")).sendKeys(First_Name);
			driver.findElement(By.name("lastName")).sendKeys(Last_Name);
			driver.findElement(By.name("phone")).sendKeys(Phone);
			driver.findElement(By.name("usertName")).sendKeys(UserName);
			//entering mailing information
			driver.findElement(By.name("address1")).sendKeys(Address);
			driver.findElement(By.name("address2")).sendKeys(Address);
			driver.findElement(By.name("city")).sendKeys(City);
			driver.findElement(By.name("state")).sendKeys(State);
			driver.findElement(By.name("postalCode")).sendKeys(PinCode);
			
			//country selection
			Select dropcountry=new Select(driver.findElement(By.name("country")));
			dropcountry.selectByVisibleText(Country);
			//entering user informatin
			driver.findElement(By.name("email")).sendKeys(UserName);
			driver.findElement(By.name("password")).sendKeys(Password);
			driver.findElement(By.name("confirmPassword")).sendKeys(Password);
			//submitting form
			driver.findElement(By.name("register")).click();
			if(driver.getPageSource().contains("Thank you for registering")) {
				System.out.println("Registeration completed for "+row+"record");
			}
			else {
				System.out.println("registration failed for"+row+"record");
			}
		}

	}

}
