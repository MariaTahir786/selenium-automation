package SeleniumDay02;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class firstJunitTest {
	
	
	 WebDriver driver;
	    
	    
	    @Before
	    public void OpenBrowser() {
	        
	        WebDriverManager.chromedriver().setup();

	        driver = new ChromeDriver();
	        
	        driver.manage().window().maximize();

	        driver.get("https://www.fb.com");
	    }
	    
	    
	    @Test
	    public void test1() {
	        String titleOfThePage = driver.getTitle();
	        System.out.println(titleOfThePage);
	    }
	    
	    @Test
	    public void test2() {
	        String currentURL = driver.getCurrentUrl();
	        System.out.println(currentURL);
	        
	        //Selenium Functions:
//	        driver.navigate().back();
//	        driver.navigate().forward();
//	        driver.navigate().refresh();
//	        driver.navigate().to("URL");



	    }
	    @After
	    public void afterMethod() {
	        driver.close();
	    }
	    
	}
	
	
	
	
	


