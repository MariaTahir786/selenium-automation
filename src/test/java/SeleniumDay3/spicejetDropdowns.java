package SeleniumDay3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class spicejetDropdowns {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;

		WebDriverManager.chromedriver().setup();

		driver=new ChromeDriver();
		driver.manage().window().maximize();

		//driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.get(" https://www.spicejet.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[contains(text(),'Add-ons')]")).click();
		String list=driver.findElement(By.xpath("//div[@class='css-76zvg2 r-homxoj r-ubezar'][normalize-space()='SpiceMax']")).getText();
		System.out.println(list);
		for(int i=1;i<10;i++) {
			driver.findElement(By.xpath("//div[@class='css-76zvg2 r-homxoj r-ubezar'][normalize-space()='Extra Seat']")).click();
			//	driver.quit();	
		}

	}

}
