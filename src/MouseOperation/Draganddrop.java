package MouseOperation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Draganddrop {

	public static void m1() throws InterruptedException{
		   //drag and drop the frame to desired position
				
			    System.setProperty
			    ("webdriver.chrome.driver","E:\\Software Testing\\AUTOMATION TESTING\\Selenium\\chrome driver 101\\chromedriver.exe");

				WebDriver driver=new ChromeDriver (); 

				driver.get("https://jqueryui.com/droppable/");

				driver.manage().window().maximize();
				
				JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("window.scrollBy(0,190)");

				WebElement frame=driver.findElement
						(By.xpath("//iframe[@class='demo-frame']"));

				driver.switchTo().frame(frame);

				WebElement objectimage=driver.findElement
						(By.xpath ("//div[@id='draggable']"));

				Actions act=new Actions (driver);

				act.clickAndHold(objectimage).perform();

				WebElement destiny=driver.findElement
						(By.xpath("//div[@id='droppable']"));
				
				Thread.sleep(1000);

				act.moveToElement(destiny).perform();

				act.release().perform();

		}
			public static void main (String []args) throws InterruptedException{

				m1();
			}
}
