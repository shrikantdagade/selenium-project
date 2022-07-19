package selenium;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Captureshots {
	
	public void screenshot(WebDriver driver,String shots ) throws IOException {
		TakesScreenshot tss=(TakesScreenshot)driver;
		File shotFile=tss.getScreenshotAs(OutputType.FILE);
		File saveFile=new File("./Screenshots/"+shots+".png");
	    FileHandler .copy(shotFile, saveFile);
				
	}

}
