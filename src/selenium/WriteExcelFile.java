package selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WriteExcelFile {
	
	public void writefile(int r,int c,String value) throws IOException {
		//Create an object of File class to open xlsx file
			File file=new File(".\\Datafile\\excel1.xlsx");
				
	  //Create an object of FileInputStream class to read excel file
			FileInputStream fis=new FileInputStream(file);
			
	  //creating workbook instance that refers to .xlsx file
			XSSFWorkbook wb=new XSSFWorkbook(fis);
	  //creating a Sheet object using the sheet Name
			XSSFSheet sheet=wb.createSheet("sheet3");
	  //Create a row object to retrieve row at index 	
			XSSFRow row=sheet.createRow(r);
			
	//create a cell object to enter value in it using cell Index
			
		    XSSFCell cell=row.createCell(c);
			cell.setCellValue(value);
	 //write the data in excel using output stream	
		   FileOutputStream fos=new FileOutputStream(file);	
		   wb.write(fos);
	 //close book
		   wb.close();
		   System.out.println("written successfully");
	}

	public static void main(String[] args) throws IOException {
		WriteExcelFile ref=new WriteExcelFile();
		//ref.writefile(0, 2, "shrikant");
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shrid\\eclipse-workspace\\Selenium project\\Driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/r.php?locale=en_GB&display=page");
		String title=driver.getTitle();
		ref.writefile(0, 0, title);
	}

}
