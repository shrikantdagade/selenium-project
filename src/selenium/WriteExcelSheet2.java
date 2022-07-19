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

public class WriteExcelSheet2 {

	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shrid\\eclipse-workspace\\Selenium project\\Driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://demoqa.com/automation-practice-form");
		File file =new File(".\\Datafile.\\excel3.xlsx");
		
		FileInputStream fis= new FileInputStream(file);
		
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheet("Sheet1");
		int lastrow=sheet.getLastRowNum();
		for(int row=1;row<=lastrow;row++) {
			XSSFRow c_row=sheet.getRow(row);
			 String FirstName=c_row.getCell(0).getStringCellValue();
			 String LastName=c_row.getCell(1).getStringCellValue();
			 String Email=c_row.getCell(2).getStringCellValue();
			 int MoNumber=(int) c_row.getCell(3).getNumericCellValue();
			// String Subject=c_row.getCell(4).getStringCellValue();
			 String Address=c_row.getCell(5).getStringCellValue();
			 String state=c_row.getCell(6).getStringCellValue();
			 String City=c_row.getCell(7).getStringCellValue();
			
			//or int prince=(int)current_row.getCell(0).getNumericCellValue();
			 
			 driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(FirstName);
			 driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(LastName);
			 driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys(Email);
			 driver.findElement(By.xpath("//label[normalize-space()='Male']")).click();
			 driver.findElement(By.xpath("//input[@id='userNumber']")).sendKeys(String.valueOf(MoNumber));
			 driver.findElement(By.xpath("//input[@id='dateOfBirthInput']")).click();
			 Select month =new Select(driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']")));
			 month.selectByVisibleText("June");
			Select year= new Select(driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']")));
			year.selectByVisibleText("1994");
             List<WebElement>dates=driver.findElements(By.xpath("//div[@class='react-datepicker__month']//div[@tabindex='-1']"))	;	
             for(WebElement ele:dates) {
            	 String date=ele.getText();
            	 if(date.equals("16")) {
            		 ele.click();
            	     break;
             }}
             
             //Select sub =new Select(driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[6]/div[2]/div")));
             //  sub.selectByVisibleText(Subject);
               
             driver.findElement(By.xpath("//*[@id=\"hobbiesWrapper\"]/div[2]/div[1]/label")).click();
             driver.findElement(By.xpath("//*[@id=\"hobbiesWrapper\"]/div[2]/div[2]/label")).click();
             driver.findElement(By.xpath("//*[@id=\"hobbiesWrapper\"]/div[2]/div[3]/label")).click();
             
             driver.findElement(By.xpath("//textarea[@id='currentAddress']")).sendKeys(Address);
             Select states=new Select(driver.findElement(By.xpath("//div[contains(text(),'Select State')]")));
             states.selectByVisibleText(state);
             Select Cities=new Select(driver.findElement(By.xpath("//div[@id='city']")));
             Cities.selectByVisibleText(City);
             
             driver.findElement(By.xpath("//button[@id='submit']")).click();
             //Verify the confirmation message
             WebElement confirmationMessage = driver.findElement(By.xpath("//div[text()='Thanks for submitting the form']"));
             
           //create a new cell in the row at index
            XSSFRow row1= sheet.createRow(row);
             
            XSSFCell cell=row1.createCell(8);
            
          //check if confirmation message is displayed
            if (confirmationMessage.isDisplayed()) {
                // if the message is displayed , write PASS in the excel sheet
                cell.setCellValue("PASS");
                
            } else {
                //if the message is not displayed , write FAIL in the excel sheet
                cell.setCellValue("FAIL");
            }
         // Write the data back in the Excel file	
            FileOutputStream fos=new FileOutputStream(file); 
            wb.write(fos);
            
            //close the confirmation popup
            WebElement closebtn = driver.findElement(By.id("closeLargeModal"));
            closebtn.click();
             
            
		}
		wb.close();
		
	}

}







