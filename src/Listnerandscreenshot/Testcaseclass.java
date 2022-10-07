package Listnerandscreenshot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Listnerandscreenshot.Listners.class)
public class Testcaseclass {
	
	 public static WebDriver driver;
		@BeforeTest
		public void launch () throws Exception {
			System.setProperty("webdriver.chrome.driver", "E:\\Software Testing\\AUTOMATION TESTING\\Selenium\\chrome driver 101\\chromedriver.exe")	;
			
			 driver=new ChromeDriver();
			
			driver.manage().window ().maximize();
			Thread .sleep(2000);
			driver.get("https://www.facebook.com/");
		}
		
	  @Test 
	  public void verifyTitle() {
		String actualtitle= driver.getTitle();
		String expected ="Facebook"; 
		
		Assert.assertEquals(actualtitle, expected);
		
	  }
	  @Test
	  public void VerifyUrl(){
		String actualLink=driver.getCurrentUrl();
		String expectedlink="https://www.facebo.com/" ;
		Assert.assertEquals(actualLink, expectedlink);  
	  }
	  @Test
	  public void Pagevalidation() {
		  System.out.println("veried that page is opening ok"); 
	  }
	  
		
		
	}
