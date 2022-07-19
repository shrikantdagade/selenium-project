package selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelsheet1 {

	public static void main(String[] args) throws IOException {
		File file=new File(".\\Datafile.\\excel1.xlsx");
		
		FileInputStream fis=new FileInputStream(file);
		
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		
		XSSFSheet sheet=wb.createSheet("sheet4");
		
		XSSFRow row=sheet.createRow(1); 
		//create a cell object to enter value in it using cell Index
		row.createCell(0).setCellValue("shrikant");
	    row.createCell(1).setCellValue("Jane");
	    row.createCell(2).setCellValue("djanes@gmail.com");
	    row.createCell(3).setCellValue("Female");
	    row.createCell(4).setCellValue("8786858432");
	    row.createCell(5).setCellValue("Park Lane, Flat C1 , New Jersey");
	    
	    //write the data in excel using output stream	
	    FileOutputStream fos=new FileOutputStream(file);
	    wb.write(fos);
	    wb.close();
	    System.out.println("written successfully");

	}

}
