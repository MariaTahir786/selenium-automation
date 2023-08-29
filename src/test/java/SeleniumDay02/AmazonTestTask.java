

package SeleniumDay02;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonTestTask {

	
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
	public void searchItem() {
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("bags");
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.findElement(By.linkText("Gift Wrap")).click();
		//driver.findElement(By.xpath("//a[@href=\"/s?k=bags+gift+wrap&ref=sr_nr_p_cosmo_multi_pt_0\"]")).click();
		int linksOnPage=driver.findElements(By.tagName("a")).size();
		System.out.println(linksOnPage);
		//Assertion
		boolean goodValueText=	driver.findElement(By.xpath("//*[text()='Sturdy. Good Value. Great Paper bags.'][1]")).isDisplayed();
		System.out.println(goodValueText);
	}
	@After
	public void tearDown() {
		
		
		driver.close();
	}
}
