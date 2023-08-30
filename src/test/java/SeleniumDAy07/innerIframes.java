package SeleniumDAy07;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class innerIframes {
	
	
	WebDriver driver;
	@Before

	public void openBrowser() {
		WebDriverManager.chromedriver().setup();

		driver=new ChromeDriver();
		driver.manage().window().maximize();

		driver.get(" https://demo.automationtesting.in/Frames.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	@After
	public void tearDown() {


		driver.close();
	}
	
		
		
		 @Test
		 public void inneriframetesting() throws InterruptedException {
			 //click button
			 driver.findElement(By.xpath("//a[normalize-space()='Iframe with in an Iframe']")).click();
			 //switch to outer frame
			 WebElement outerFrame=driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']"));
			 driver.switchTo().frame(outerFrame);
			 //switch to inner frame
			 WebElement innerFrame=driver.findElement(By.xpath("/html/body/section/div/div/iframe"));
			 driver.switchTo().frame(innerFrame);
			 //get element and send kesys
			 driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Welcome to my class");
			 Thread.sleep(3000);
			 driver.switchTo().parentFrame();
			 WebElement textTitle=driver.findElement(By.xpath("//h5[normalize-space()='Nested iFrames']"));
			 String text=textTitle.getText();
			 System.out.println(text);
		 }
		 }
	
	
	


