package Excelread;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Excelread3 {
	/* here we have excel with multiple data for login to facebook
	 * that we have fetched and used in our script 
	 */

	WebDriver driver;
	@BeforeTest 
	public void launch() {
			
		System.setProperty("webdriver.chrome.driver", 
				"E:\\Software Testing\\AUTOMATI"
				+ "ON TESTING\\Selenium\\chrom"
				+ "e driver 101\\chromedriver.exe")	;
			
	    driver=new ChromeDriver();
			
		driver.manage().window ().maximize();
			
		driver.get("https://www.facebook.com/");
	}
	
	@Test (dataProvider="test data")
	public void login(String user,String pass) throws Exception {
		
		WebElement username=driver.findElement(By.xpath("//input[@id='email']"));
		
		username.sendKeys(user);
		
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(pass);
		
		driver.findElement(By.tagName("button")).click();
		
		driver.navigate().back();
	
		driver.findElement(By.xpath("//input[@id='email']")).clear();
	}
	String [][]data;
	@DataProvider (name="test data") 
	public String[][] readexcel() throws IOException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		
		String filepath = ".\\Facebooklogin.xlsx";
		
		FileInputStream workfile=new FileInputStream (filepath);
		
		XSSFWorkbook workbook=new XSSFWorkbook(workfile);
		
		//XSSFSheet sheet=workbook.getSheetAt(0);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		int rowcount =sheet.getLastRowNum();
		
		int col = sheet.getRow(0).getLastCellNum();
		String value;
		
		data=new String [rowcount+1][col];
		
	for (int i=0;i<=rowcount; i++ )
	{
		
		
		for(int n=0; n<col; n++) 
		{
			
		data [i][n] =sheet.getRow(i).getCell(n).getStringCellValue();
			
		}
				
	}
		return data;
		}
}
