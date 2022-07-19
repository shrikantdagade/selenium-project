package selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class WriteExcelsheet3 {

	public static void main(String[] args) throws IOException {
		  //set the ChromeDriver path
        System.setProperty("webdriver.chrome.driver","C:\\Users\\shrid\\eclipse-workspace\\Selenium project\\Driver\\chromedriver.exe");

        //Create an object of File class to open xls file
        File file = new File(".\\Datafile.\\excel4.xlsx");
        
        //Create an object of FileInputStream class to read excel file
        FileInputStream inputStream = new FileInputStream(file);
        
        //creating workbook instance that refers to .xls file
        XSSFWorkbook wb=new XSSFWorkbook(inputStream);
        
        //creating a Sheet object
        XSSFSheet sheet=wb.getSheet("Sheet1");
        
        //get all rows in the sheet
        int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();
        
       //Creating an object of ChromeDriver
        WebDriver driver = new ChromeDriver();
        
        //Navigate to the URL
        driver.get("https://demoqa.com/automation-practice-form");


        //Identify the WebElements for the student registration form
        WebElement firstName=driver.findElement(By.id("firstName"));
        WebElement lastName=driver.findElement(By.id("lastName"));
        WebElement email=driver.findElement(By.id("userEmail"));
        WebElement genderMale= driver.findElement(By.id("gender-radio-1"));
        WebElement mobile=driver.findElement(By.id("userNumber"));
        WebElement address=driver.findElement(By.id("currentAddress"));
        WebElement submitBtn=driver.findElement(By.xpath("//button[@id='submit']"));



        //iterate over all the rows in Excel and put data in the form.
        for(int i=1;i<=rowCount;i++) {
            //Enter the values read from Excel in firstname,lastname,mobile,email,address
            firstName.sendKeys(sheet.getRow(i).getCell(0).getStringCellValue());
            lastName.sendKeys(sheet.getRow(i).getCell(1).getStringCellValue());
            email.sendKeys(sheet.getRow(i).getCell(2).getStringCellValue());
            mobile.sendKeys(String.valueOf(sheet.getRow(i).getCell(4).getNumericCellValue()));
            address.sendKeys(sheet.getRow(i).getCell(5).getStringCellValue());
            
            //Click on the gender radio button using javascript
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", genderMale);
            
            //Click on submit button
            submitBtn.click();
            
            //Verify the confirmation message
            WebElement confirmationMessage = driver.findElement(By.xpath("//div[text()='Thanks for submitting the form']"));
            
            //create a new cell in the row at index 6
            XSSFCell cell = sheet.getRow(i).createCell(6);
            
            //check if confirmation message is displayed
            if (confirmationMessage.isDisplayed()) {
                // if the message is displayed , write PASS in the excel sheet
                cell.setCellValue("PASS");
                
            } else {
                //if the message is not displayed , write FAIL in the excel sheet
                cell.setCellValue("FAIL");
            }
            
            // Write the data back in the Excel file
            FileOutputStream outputStream = new FileOutputStream(file);
            wb.write(outputStream);

            //close the confirmation popup
            WebElement closebtn = driver.findElement(By.id("closeLargeModal"));
            closebtn.click();
            
            //wait for page to come back to registration page after close button is clicked
            driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
        }
        
        //Close the workbook
        wb.close();
        
        //Quit the driver
        driver.quit();

	}

}
