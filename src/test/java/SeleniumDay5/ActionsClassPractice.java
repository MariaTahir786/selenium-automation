package SeleniumDay5;

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

public class ActionsClassPractice {

	
	WebDriver driver;
	

	@Before
	public void setUp() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://www.amazon.com");
		driver.manage().window().maximize();

		// implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void hoverOver() {
		//hover over "Hello sign in button"
		 WebElement signInButton = driver.findElement(By.id("nav-link-accountList"));
	        
	        // Create an Actions object
	        Actions actions = new Actions(driver);
	        
	        // Perform mouse hover action
	        actions.moveToElement(signInButton).perform();
	        
	       // activity 
	        //hover over 2 more elements on this page
	    }
	}


