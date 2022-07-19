package selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WritetoExcelsheet5 {

	public static void main(String[] args) throws IOException {
       
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shrid\\eclipse-workspace\\Selenium project\\Driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://en.wikipedia.org/wiki/List_of_countries_and_dependencies_by_population");;
		driver.manage().window().maximize();
		
		String path=System.getProperty("user.dir")+ "\\excel5.xlsx";
		
		File file =new File(path);
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.createSheet("Sheet3");
		
		WebElement table=driver.findElement(By.xpath("//table[@class='wikitable sortable jquery-tablesorter']/tbody"));
	    int row=table.findElements(By.xpath("tr")).size();//rows present in table
	     
	    for(int r=1;r<=row;r++) {
	    	XSSFRow row1=sheet.createRow(r);
	    	String Rank=table.findElement(By.xpath("tr["+r+"]/td[1]")).getText();
	    	String Country=table.findElement(By.xpath("tr["+r+"]/td[2]")).getText();
	    	String Region=table.findElement(By.xpath("tr["+r+"]/td[3]")).getText();
	    	String Population=table.findElement(By.xpath("tr["+r+"]/td[4]")).getText();
	    	String Percentage_world=table.findElement(By.xpath("tr["+r+"]/td[5]")).getText();
	    	String Date=table.findElement(By.xpath("tr["+r+"]/td[6]")).getText();
	    	String Source=table.findElement(By.xpath("tr["+r+"]/td[7]")).getText();
	    	
	    	
	         
	    	System.out.println(Rank+Country+Region+Population+Percentage_world+Date+Source);
	    	
	    	row1.createCell(0).setCellValue(Rank);
	    	row1.createCell(1).setCellValue(Country);
	    	row1.createCell(2).setCellValue(Region);
	    	row1.createCell(3).setCellValue(Population);
	    	row1.createCell(4).setCellValue(Percentage_world);
	    	row1.createCell(5).setCellValue(Date);
	    	row1.createCell(6).setCellValue(Source);
	    //	row1.createCell(7).setCellValue(Notes);
	    	
	    	FileOutputStream fos=new FileOutputStream(file); 
            wb.write(fos);	    	
	    	
	    	
	    }
	    wb.close();
	    driver.close();
	}
	 	
	}


