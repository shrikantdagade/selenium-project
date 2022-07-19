package selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class HandleReadFile {
	 public static String readfileas(int r, int c) throws IOException {
		String path =".\\Datafile\\excel1.xlsx";
		 //step2 use file class
		 File fs=new File(path);
		 //step3 read the file
		 FileInputStream fis=new FileInputStream(fs);
		 //step4 handle excel file workbook
		 XSSFWorkbook wb =new XSSFWorkbook(fis);
		 //step5 locate sheet inside file
		 XSSFSheet sheet =wb.getSheet("sheet1");
		 //step6 get rows and col
	     XSSFRow row=sheet.getRow(r); 
	     XSSFCell cell=row.getCell(c);
	     //step7 value from cell
	     String value=cell.getStringCellValue();
	     //step8 close workbook
	     wb.close();
	     return value;
		  
	  }


	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shrid\\eclipse-workspace\\Selenium project\\Driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/login/");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys(readfileas(0, 0));
		driver.findElement(By.id("pass")).sendKeys(readfileas(0, 1));
	 
	}

}
