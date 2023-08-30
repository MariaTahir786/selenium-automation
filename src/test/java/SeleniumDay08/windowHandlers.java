package SeleniumDay08;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class windowHandlers {

	// We use driver.getWindowHandle's' because we are looking for more than one id
	// and if we do
	// just handle, its gonna give us the parent window id.

	// We store them in a Set<String> because it is of String value and is more than
	// one.
	// We use Iterator to store the parent and child id's ({it.next}).
	// We use driver.switchTo().window(childID) to switch to the other window opened
	// ID.
	WebDriver driver;

	@Before
	public void openBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@After
	public void teardown() {
		driver.close();
	}

	@Test
	public void switchToAnotherTabTest() throws InterruptedException {
		// getting title of the page before clicking on a tab and switching over
		String mainTitleName = driver.getTitle();
		System.out.println(mainTitleName);

		// getting parent window handle
		String parentHandle = driver.getWindowHandle();
		System.out.println("parentHandle  " + parentHandle);
		Thread.sleep(3000);
		// clicking on a button to open new tab
		// driver.findElement(By.id("newWindowBtn")).click();
		WebElement childID = driver.findElement(By.xpath("//button[@id='newWindowBtn']"));

		// Scroll the button into view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", childID);
		childID.click();
		// becoz 2 windows are opened so getting all the open windows and storing them
		// in a set of strings
		Set<String> handlesIds = driver.getWindowHandles();
		for (String handle : handlesIds) {
			System.out.println(handle);
			 //if we want to send text in child window we have to switch to child window
			//so put a condition if its not a parent then switch it
			if(!handle.equals(parentHandle)) {
				driver.switchTo().window(handle);
				
				// find that element in child window and send keys
				driver.findElement(By.id("firstName")).sendKeys("Mariaaa");
				
				//then we will close the current window by close(only focussed ) ...quit will close all 
				Thread.sleep(3000);
				driver.close();
			}
		}
			driver.switchTo().window(parentHandle);
		//now we have to send text in parent window so locate  and send keys
		WebElement textbox=driver.findElement(By.id("name"));
		// Scroll the button into view
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", textbox);
		textbox.sendKeys("Tahir");
		Thread.sleep(2000);
	}

}
