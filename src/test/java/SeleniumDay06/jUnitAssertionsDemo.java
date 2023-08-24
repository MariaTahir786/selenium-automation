package SeleniumDay06;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class jUnitAssertionsDemo {

	
	WebDriver driver;

    @Before
    public void setUp()  {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://www.amazon.com/");
        driver.manage().window().maximize();

        // implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
	    @After
	    public void tearDown() {
	        driver.quit();
	    }

	    @Test
	    public void testLogoPresence() {
	        WebElement logo = driver.findElement(By.id("nav-logo-sprites"));
	        assertTrue("Logo is not displayed.", logo.isDisplayed());
	    }

	    @Test
	    public void testTextPresence() {
	        WebElement heading = driver.findElement(By.xpath("//a[normalize-space()='Back to School']"));
	        String expectedText = "Back to School";
	        assertEquals("Heading text doesn't match.", expectedText, heading.getText());
	    }

	    @Test
	    public void testURL() {
	        String expectedURL = "https://www.amazon.com/";
	        String actualURL = driver.getCurrentUrl();
	        assertEquals("URLs don't match.", expectedURL, actualURL);
	    }

//	    @Test
//	    public void testElementAbsence() {
//	        List<WebElement> errorMessage = driver.findElements(By.className("error"));
//	        assertTrue("Error message is present.", errorMessage.isEmpty());
//	    }

	   

	    @Test
	    public void testCustomErrorMessage() {
	        WebElement button = driver.findElement(By.id("nav-logo-sprites"));
	        assertTrue("Button is not enabled for interaction.", button.isEnabled());
	    }
	}

	
	
	
	
	

