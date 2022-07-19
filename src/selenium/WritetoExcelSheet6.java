package selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WritetoExcelSheet6 {

	public static void main(String[] args) throws IOException {
     String path =System.getProperty("user.dir")+"\\excel5.xlsx";
     File file=new File(path);
     FileInputStream fis=new FileInputStream(file);
     XSSFWorkbook wb=new XSSFWorkbook(fis);
	XSSFSheet sheet=wb.createSheet("Sheet4");
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\shrid\\eclipse-workspace\\Selenium project\\Driver\\chromedriver1.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("https://business.mapsofindia.com/india-company/");
	driver.manage().window().maximize();
	List<WebElement>table=driver.findElements(By.xpath("(//table[@class='tableizer-table'])[1]/tbody/tr"));
	int rows=table.size();
	System.out.println(rows);
	 for(int r=2;r<=rows;r++) {
		 XSSFRow row=sheet.createRow(r);
		 String Global_Rank=driver.findElement(By.xpath("(//table[@class='tableizer-table'])[1]/tbody/tr["+r+"]/td[1]")).getText();
		 String Indian_Companies=driver.findElement(By.xpath("(//table[@class='tableizer-table'])[1]/tbody/tr["+r+"]/td[2]")).getText();
		 String Sales=driver.findElement(By.xpath("(//table[@class='tableizer-table'])[1]/tbody/tr["+r+"]/td[3]")).getText();
		 String Profits=driver.findElement(By.xpath("(//table[@class='tableizer-table'])[1]/tbody/tr["+r+"]/td[4]")).getText();
		 String Assets=driver.findElement(By.xpath("(//table[@class='tableizer-table'])[1]/tbody/tr["+r+"]/td[5]")).getText();
		 String Market_Value=driver.findElement(By.xpath("(//table[@class='tableizer-table'])[1]/tbody/tr["+r+"]/td[6]")).getText();
		 
		 System.out.println(Global_Rank+ Indian_Companies+Sales+Profits+Assets+Market_Value);
		 
		 row.createCell(0).setCellValue(Global_Rank);
		 row.createCell(1).setCellValue(Indian_Companies);
		 row.createCell(2).setCellValue(Sales);
		 row.createCell(3).setCellValue(Profits);
		 row.createCell(4).setCellValue(Assets);
		 row.createCell(5).setCellValue(Market_Value);
		 
		 FileOutputStream fos=new FileOutputStream(file); 
         wb.write(fos);	 
	 }
	wb.close();
	
	}

}
