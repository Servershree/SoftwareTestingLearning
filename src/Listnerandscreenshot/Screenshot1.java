package Listnerandscreenshot;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot1 {

	public void screenshot(WebDriver driver,String name) throws IOException {

	TakesScreenshot screenshot1=(TakesScreenshot)driver;
	
	
	File source=screenshot1.getScreenshotAs(OutputType.FILE);
	
	File destiny=new File
			(System.getProperty("user.dir") + "\\Screenshot\\"+name+".png");
	
	FileHandler.copy(source, destiny);
		
	System.out.println("Screen shot captured");
	}

}
