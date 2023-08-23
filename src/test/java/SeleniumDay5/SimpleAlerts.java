package SeleniumDay5;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SimpleAlerts {



	WebDriver driver;
	@Before

	public void openBrowser() {
		WebDriverManager.chromedriver().setup();

		driver=new ChromeDriver();
		driver.manage().window().maximize();

		//Url 1 for simple alert
		//driver.get(" https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
		
		//Url 2 for confirmation Alert
		//driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_confirm");
		
		//Url 3 Prompt alert 
		 driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}


	/*
	@Test
	//Assuming you have a page with a button that triggers a simple alert:

	public void handleSimpleAlerts() {
		//If element is in  iframe
	driver.switchTo().frame("iframeResult");

    WebElement triggerButton = driver.findElement(By.tagName("button"));
    triggerButton.click();

    Alert alert = driver.switchTo().alert();
    System.out.println("Alert Text: " + alert.getText());
    //for confirmation alert use accept()
    alert.accept();
	        driver.quit();


	}*/



	//@Test
	/*2. Confirmation Alert Example:
		 Assuming you have a page with a button that triggers a confirmation alert:*/

	/*public void confirmationAlert() {

		driver.switchTo().frame("iframeResult");

		WebElement triggerButton = driver.findElement(By.tagName("button"));
		triggerButton.click();

		Alert alert = driver.switchTo().alert();
		System.out.println("Alert Text: " + alert.getText());
		// alert.dismiss(); // Click "Cancel"
		alert.accept();

	}
	*/

	
	@Test
	public void promptAlertExample() {
		
		/*3. Prompt Alert Example:
			Assuming you have a page with a button that triggers a prompt alert:*/
		
		 driver.switchTo().frame("iframeResult");

	        WebElement triggerButton = driver.findElement(By.tagName("button"));
	        triggerButton.click();

	        Alert alert = driver.switchTo().alert();
	        System.out.println("Alert Text: " + alert.getText());

	        alert.sendKeys("Hello, Selenium!");
	        alert.accept();

		
		
	}


	@After
	public void tearDown() {


		driver.close();
	}



}














