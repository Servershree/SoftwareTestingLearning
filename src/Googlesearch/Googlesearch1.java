package Googlesearch;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Googlesearch1 {
	/* Code for Google Search 
	 * search with "testing" word you will get options from google search 
	 * from that you can select the option you want.
	 */
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","E:\\Software "
				+ "Testing\\AUTOMATION TESTING\\Selenium\\chrome driver 101\\chromedriver.exe");	
			
		WebDriver driver=new ChromeDriver();	
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		driver.get("https://www.google.com/");	
		
		driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("Testing");
	
		
		List<WebElement> List=driver.findElements
				(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='wM6W7d']"));
		
		
		int totaloptions=List.size();
		System.out.println(totaloptions + " total options");
		
		for (WebElement option:List) {
			if (option.getText().equals("testing types")) {
				option.click();
			}}
}}
