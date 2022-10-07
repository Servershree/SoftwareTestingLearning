package CrossBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Crossbrowser {
	/*crossbrowser testing using chrome and gecko driver 
	 *and also using parameterization concept
	 * TestNG
	 */
	
	
	WebDriver driver;
		
	@Parameters ("browser")
	@BeforeTest
	public void browser (String type) {
			
	//chrome		
	if(type.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", 
						   "E:\\Software Testing\\AUTOMATION TESTING\\Seleni"
						   + "um\\chrome driver 101\\chromedriver.exe");
				 driver = new ChromeDriver();
				 
				 driver.manage().window().maximize();
				
				 driver.get("https://vctcpune.com/selenium/practice.html");
			
				}
	//edge			
	else {
	if(type.equals("gecko")) {
						System.setProperty("webdriver.gecko.driver", 
								   "E:\\Software Testing\\AUTOMATION TESTING"
								   + "\\Selenium\\geckodriver\\geckodriver.exe");
						 driver = new FirefoxDriver();
						 
						 driver.manage().window().maximize();
						
						 driver.get("https://vctcpune.com/selenium/practice.html");
	    }     }
    }
	//Test case
	@Test
    public void login() {
		String actual = driver.getTitle();
		String expected ="Practice Page"; 

		Assert.assertEquals(expected, actual);
		}
    }