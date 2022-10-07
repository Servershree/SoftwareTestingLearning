package WindowHandling;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling1 {
	
	public static void m1() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", 
				   "E:\\Software Testing\\AUTOMATION TESTING\\Seleni"
				   + "um\\chrome driver 101\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://vctcpune.com/selenium/practice.html");
		
		driver.manage().window().maximize();
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,600)");
		Thread.sleep(2000);

		String id= getWindowHandle();
		Thread.sleep(2000);
		WebElement opentabbutton =driver.findElement(By.id("opentab"));
		opentabbutton.click();
		Thread.sleep(2000);
		Set<String> listofwindow=driver.getWindowHandles();
		Thread.sleep(2000);
		System.out.println(listofwindow);
		for(String tab:listofwindow){
			
			if (!tab.equals(listofwindow)) {
				
				driver.switchTo().window(tab);
				String title=driver.getTitle();
				System.out.println(title);
			}
	}
		Thread.sleep(2000);
		}
		private static Set<String> getWindowHandles() {
			// TODO Auto-generated method stub
			return null;
		}
		private static String getWindowHandle() {
			// TODO Auto-generated method stub
			return null;
		}
		public static void main(String[] args) throws Exception {
			// TODO Auto-generated method stub
	    m1();
	    }
		}


