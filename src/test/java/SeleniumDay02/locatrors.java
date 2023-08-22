package SeleniumDay02;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class locatrors {
WebDriver driver;
	@Before
	
public void openBrowser() {
		WebDriverManager.chromedriver().setup();
		
		driver=new ChromeDriver();
		 driver.manage().window().maximize();

	        //driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			 driver.get(" https://www.amazon.com/");
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	@Test
	public void orangeHrmLoginValidCredentials() {
		
		WebElement userNmae=driver.findElement(By.name("username"));
		userNmae.clear();
		userNmae.sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		
		
	}
	
	@After
	public void closeBrowser() {
		driver.close();
		
		
	}
	

}
