package Excelread;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Excelread2 {
public static  String readData(int r, int c) throws IOException {
		// Single row and Two columns data read from Excel
	
		//step-1 locate file
		String path=".\\Data.xlsx";
		
		//step 2- File class to handle file
		File file =new File(path);
		
		//step-3 Read file via input straem
		FileInputStream fis=new FileInputStream(file);
		System.out.println("1");
		//step-4 Use poi classes to read data -create Work book object
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		System.out.println("2");
		//step- 5 locate sheet
		
		XSSFSheet sheet=wb.getSheetAt(0);
		
		//step-6 read cell value
		String val=sheet.getRow(r).getCell(c).getStringCellValue();
		
		//step-7 close file after read
		wb.close();
		
		return val;

	    }

	public static void main(String[] args) throws IOException, InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", 
				   "E:\\Software Testing\\AUTOMATION TESTING\\Seleni"
				   + "um\\chrome driver 101\\chromedriver.exe");
		
		//step-1 Launch browser
		WebDriver driver=new ChromeDriver();
		
		//Step-2 Maximize window
		driver.manage().window().maximize();
		
		//step-3
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		
		//step-4 enter log in cred
		WebElement username=driver.findElement
		(By.xpath("//input[@name='username']"));
		username.sendKeys(readData(0,0));
		WebElement password=driver.findElement
		(By.xpath("//input[@name='password']"));
		password.sendKeys(readData(0,1));
		WebElement button=driver.findElement
		(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']"));
		
		button.click();
		
		//driver.close();

	   }

}

