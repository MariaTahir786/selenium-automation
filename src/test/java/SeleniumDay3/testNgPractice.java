package SeleniumDay3;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testNgPractice {
WebDriver driver;
	@Test
	public void testGoogle() throws InterruptedException {
		
	    WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        
        driver.manage().window().maximize();

        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("Tech Circle school",Keys.ENTER);
        System.out.println(driver.getTitle());
        Thread.sleep(3000);
        driver.quit();
	}
	
	@Test
	public void testFacebook() throws InterruptedException {
		
	    WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        
        driver.manage().window().maximize();

        driver.get("https://www.google.com");
        driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("TechCircle School",Keys.ENTER);
        System.out.println(driver.getTitle());
        Thread.sleep(3000);
        driver.quit();
	}
	
	
	
}
