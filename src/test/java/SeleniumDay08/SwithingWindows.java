package SeleniumDay08;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwithingWindows {

	WebDriver driver;

	@Before
	public void openBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.automationtesting.in/Windows.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

//	@After
//	public void teardown() {
//		driver.close();
//	}

	@Test
	public void switchToAnotherTabTest() {

		driver.findElement(By.xpath("//a[normalize-space()='Open New Tabbed Windows']")).click();
		driver.findElement(By.xpath(
				"//a[@href='http://www.selenium.dev']//button[@class='btn btn-info'][normalize-space()='click']"))
				.click();

		// to check which window driver is actually handling
		String parentWindow = driver.getTitle();
		System.out.println(parentWindow);

		// now we have 2 windows opened so get their unique id and  store them in set to get unique
		//this method will return us all the opened windows ids
		Set<String> s = driver.getWindowHandles();
		
		//now we have to read each id 
		
		for(String i:s) {
			
			//now this "i" is containing the ids of windows so to switch to them 
			
			String t=driver.switchTo().window(i).getTitle();
			//System.out.println(t);
		    //now lets get the ids 
			//System.out.println(i);
			
	//how to close one of the opened window
			if(t.contains("Selenium")) { //closing parent window
				driver.close();
				
				
			}
			
		}
		
	}

}
