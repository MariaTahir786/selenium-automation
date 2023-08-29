package SeleniumDAy07;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class iFrameePractice {
	
	//for this one  ms. Maria create seleneium dev class example
	

	WebDriver driver;
	@Before

	public void openBrowser() {
		WebDriverManager.chromedriver().setup();

		driver=new ChromeDriver();
		driver.manage().window().maximize();

		driver.get(" https://www.amazon.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	@After
	public void tearDown() {


		driver.close();
	}
	
		
		
		 @Test
		 public void iframetesting() {
			 
			 //to get totoal no of iframes 
			 List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
			 System.out.println("Total number of iframes are " + iframeElements.size());
			 
			 
			 
			 // Switch to iframe using index
		        driver.switchTo().frame(3); // Assuming the first iframe on the page

		        // Now you can interact with elements inside the iframe
		        WebElement searchBox = driver.findElement(By.name("searchboxinput"));
		        searchBox.sendKeys("Your location");

		        // Switch back to the main page context
		        driver.switchTo().defaultContent();

		        // Switch to iframe using name or ID attribute
		        driver.switchTo().frame("iframe-name-or-id");

		        // Continue interacting with elements inside the new iframe
		        WebElement someElementInsideIframe = driver.findElement(By.id("element-inside-iframe"));
		        someElementInsideIframe.click();

		        // Switch back to the main page context
		        driver.switchTo().defaultContent();

		        // Continue interacting with elements outside iframes
		        WebElement someElement = driver.findElement(By.id("some-element-id"));
		        someElement.click();

		        // Don't forget to close the browser when you're done
		        driver.quit();
		    }
			 
			 
			 
			 
			 
			 
			 
		 }
	
	
	
	
	
	
	
	
	
	

