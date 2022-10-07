package Framehandling;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Framehandling.Calenderhandling;

public class Calenderhandling {
/* calender handling and frame handling using selenium
 * Switch to frame and handle the calender 
 * again switch to default frame bydefaultcotent method
 */
	
public void handleCal() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","E:\\Software Testing\\AUTOMATION TESTING\\Selenium\\chrome driver 101\\chromedriver.exe");
		
		//step-1 Launch browser
		WebDriver driver=new ChromeDriver();
		
		//Step-2 Maximize window
		driver.manage().window().maximize();
		
		//implecitilywaits
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//step-3 launch uRL
		driver.get("https://jqueryui.com/datepicker/");
		
		JavascriptExecutor js=(	JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,190)");
		
		//step-4 find out wheter it part of frame
		WebElement frame1=driver.findElement
				(By.xpath("//iframe[@class='demo-frame']"));
		
		//step-5 switch to frame
		driver.switchTo().frame(frame1);
	
		//step-6 click on calender button
		WebElement cal=driver.findElement(By.xpath("//input[@id='datepicker']"));
		cal.click();
		Thread .sleep(2000);
		
		//step-7 handle calender-find out month year
		while(true) {
			
			String month=driver.findElement
					(By.xpath("//div[@class='ui-datepicker-title']")
							).getText();
			String dateyear="April 2020";
			if (!month.equalsIgnoreCase(dateyear)) {
			driver.findElement(By.xpath("//a[@title='Prev']")).click();
				
			} else {
				
				break;
			}
			}
		
		//step-8 select date-
		int name=20;
		driver.findElement(By.xpath("//table"
				+ "[@class='ui-datepicker-calendar']"
				+ "//tbody//tr//td//a[text()='"+ name+"']")).click();
		Thread .sleep(2000);
		
		driver.switchTo().defaultContent();
		
		js.executeScript("window.scrollBy(0,500)");
}

	public static void main(String[] args) throws InterruptedException {
	
		Calenderhandling ref=new Calenderhandling() ;
		
		ref.handleCal();
		
	}

}
