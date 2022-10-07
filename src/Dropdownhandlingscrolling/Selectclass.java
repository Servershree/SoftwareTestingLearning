package Dropdownhandlingscrolling;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Selectclass {

	public  void Selectdropdown() throws Exception{
		System.setProperty("webdriver.chrome.driver", 
				   "E:\\Software Testing\\AUTOMATION TESTING\\Seleni"
				   + "um\\chrome driver 101\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://demoqa.com/select-menu");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		JavascriptExecutor js= (JavascriptExecutor) driver;
		
		js.executeScript("window.scrollBy(0,100)");
		
		WebElement drop= driver.findElement(By.id("oldSelectMenu"));
		drop.click();
		
		
		Select ref=new Select (drop);
		/*object has obtained all types of option present  
		 * in drop down now we have to just call that method by using object and some 
		 * method s for Select class */
		//ref.selectByIndex(9);
		//ref.selectByVisibleText("Magenta");
	    List<WebElement> ElementList=ref.getOptions();
		Thread.sleep(4000);
		System.out.println(ElementList.size());
		for (WebElement ele:ElementList) {
			
			String option=ele.getText();
			System.out.println(option);
			if (option.equals("Magenta")) {
				ele.click();
			}
		}
        drop.click();
	    }
		public static void main(String[] args)throws Exception {
			// TODO Auto-generated method stub
			Selectclass var=new Selectclass();
	     var.Selectdropdown();
}}
