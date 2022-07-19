package selenium;

import java.io.File;
import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WritetoExcel7 {

	public static void main(String[] args) throws IOException {
		String path=System.getProperty("user.dir")+"\\excel5.xlsx";
		File file=new File(path);
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook wb =new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.createSheet("sheet8");
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shrid\\eclipse-workspace\\Selenium project\\Driver\\chromedriver1.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://en.wikipedia.org/wiki/List_of_universities_in_India");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement table=driver.findElement(By.xpath("//table[@class='wikitable sortable jquery-tablesorter']"));
		JavascriptExecutor ja =(JavascriptExecutor)driver;
		ja.executeScript("arguments[0].scrollIntoView(true)", table);
		
		List<WebElement> rows=driver.findElements(By.xpath("//table[@class='wikitable sortable jquery-tablesorter']/tbody/tr"));
		int row=rows.size();
		for(int r=1;r<=row;r++) {
			XSSFRow rowss=sheet.createRow(r);
			String state= driver.findElement(By.xpath("//table[@class='wikitable sortable jquery-tablesorter']/tbody/tr["+r+"]/td[1]")).getText();
			String c_univercity= driver.findElement(By.xpath("//table[@class='wikitable sortable jquery-tablesorter']/tbody/tr["+r+"]/td[2]")).getText();
			String s_univercity= driver.findElement(By.xpath("//table[@class='wikitable sortable jquery-tablesorter']/tbody/tr["+r+"]/td[3]")).getText();
			String D_univercity= driver.findElement(By.xpath("//table[@class='wikitable sortable jquery-tablesorter']/tbody/tr["+r+"]/td[4]")).getText();
			String P_univercity= driver.findElement(By.xpath("//table[@class='wikitable sortable jquery-tablesorter']/tbody/tr["+r+"]/td[5]")).getText();
			String total= driver.findElement(By.xpath("//table[@class='wikitable sortable jquery-tablesorter']/tbody/tr["+r+"]/td[6]")).getText();
             
		
		System.out.println(state+c_univercity+s_univercity+D_univercity+P_univercity+total);

                 rowss.createCell(0).setCellValue(state);
                 rowss.createCell(1).setCellValue(c_univercity);
                 rowss.createCell(2).setCellValue(s_univercity);
                 rowss.createCell(3).setCellValue(D_univercity);
                 rowss.createCell(4).setCellValue(P_univercity);

                 rowss.createCell(5).setCellValue(total);
                 
                 FileOutputStream fos =new FileOutputStream(file);
                 wb.write(fos);

		}
		wb.close();
		System.out.println("written successfully");
	
	}

}
