package SeleniumDay4;



	
	
	
	import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

	public class Alerts {
		WebDriver driver;
		

		@Before
		public void setUp() throws InterruptedException {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("http://the-internet.herokuapp.com/context_menu");
			driver.manage().window().maximize();

			// implicit wait
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		@After
		public void tearDown() {
			//driver.quit();
		}

		@Test
		public void handlingAlerts() {
			WebElement contextMenuArea = driver.findElement(By.id("hot-spot"));
	        
	        // Create an Actions object
	        Actions actions = new Actions(driver);
	        
	        // Perform right-click action
	        /*actions.contextClick(contextMenuArea) creates a right-click action using the
	         *  Actions class on the contextMenuArea element.
		.perform() is used to trigger the actual execution of the right-click action on the web page.*/
	        actions.contextClick(contextMenuArea).perform();
	        
	        // Dismiss the alert
	        driver.switchTo().alert().dismiss();
			
		}
	}

