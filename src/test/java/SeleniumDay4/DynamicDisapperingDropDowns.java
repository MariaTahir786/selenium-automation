package SeleniumDay4;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicDisapperingDropDowns {

 // dynamic disappeeraing drop down will be captured via souce tab by 
	//pausing execution or via selectors hub debugging button which will pause the execution 
	//after 5 seconds(during that 5 seconds quickly opn the disappearing drop down) and we
	//can inspect the disapperaing element
	WebDriver driver;
	

	@Before
	public void setUp() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();

		// implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void staticDropDown() throws InterruptedException {

		//loggin in
		WebElement userNmae=driver.findElement(By.name("username"));
		userNmae.clear();
		userNmae.sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();


		//navigating to Admin page
		driver.findElement(By.xpath("//a[@href='/web/index.php/admin/viewAdminModule']//span")).click();
		
		//user role drop down
		WebElement dropdownElement= driver.findElement(By.xpath("(//div)[37]"));
		dropdownElement.click();
		
	
		WebElement adminOption= driver.findElement(By.xpath("//div[@role='listbox']//div[2]"));
		adminOption.click();

		Thread.sleep(5000);



	}

// activity 
	// automate the next drop down "Status"








}
