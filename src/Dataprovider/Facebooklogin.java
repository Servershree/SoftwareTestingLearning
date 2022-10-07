package Dataprovider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Facebooklogin {
   /*  Facebook login using dataprovider parameters
    *  
    * 
    */
	
	 WebDriver driver;
	 @BeforeTest
public void launch() {	
		
		 System.setProperty("webdriver.chrome.driver", 
				 "E:\\Software Testing\\AUTOMATION T"
		+ "ESTING\\Selenium\\chrome drive"
		+ "r 101\\chromedriver.exe")	;
		
		 driver=new ChromeDriver();
			
		 driver.manage().window ().maximize();
		 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
		 driver.get("https://www.facebook.com/");}
	     
	 @Test (dataProvider="test data")
public void login(String user,String pass) throws Exception {
		
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		 
		 WebElement username=driver.findElement(By.xpath("//input[@id='email']"));
		 username.sendKeys(user);
	
		 driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(pass);
	
		 driver.findElement(By.tagName("button")).click();
	     Thread.sleep(1000);
		 driver.navigate().back();
	
		 driver.findElement(By.xpath("//input[@id='email']")).clear();
		   }
	
	 @DataProvider(name="test data")
public String [] [] getdata(){
		 
		String [][] value= {
		{"abc@gmail.com","abc@123"},
		{"Amit@gmail.com","amit@123"},
		{"sameer@gmail.com","dsasds@123"}};
		
		return value ;
	}
}
