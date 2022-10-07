package MouseOperation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Slideraction {
    //Slidermovements in x direction
	
	public static void m1()throws Exception {

		System.setProperty("webdriver.chrome.driver","E:\\Software Testing\\AUTOMATION TESTING\\Selenium"
	+ "\\chrome driver 101\\chromedriver.exe");

		WebDriver driver=new ChromeDriver ();

		driver.get("https://jqueryui.com/slider/");

		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		WebElement frame=driver.findElement
				(By.xpath("//iframe[@class='demo-frame']"));

		driver.switchTo().frame(frame);

		WebElement slider=driver.findElement
				(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default']"));

		Actions act=new Actions(driver);

		act.clickAndHold(slider).perform();
		
		act.moveByOffset(200,0).perform();
	
		act.release().perform();

		Thread.sleep(4000);

		driver.close();

}
	public static void main (String [] args) throws Exception{

		m1();
}

}
