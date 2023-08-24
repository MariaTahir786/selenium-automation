package SeleniumDay06;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assertions {

	
	WebDriver driver;

    @Before
    public void setUp() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/");
        driver.manage().window().maximize();

        // implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void assertEqualsTest() {

        String actualWelcomeText = driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText();

        String expectedWelcomeText = "Welcome to the-internet";

        Assert.assertEquals(expectedWelcomeText, actualWelcomeText);

    }
    
    @Test
    public void AssertEquals() {
    	
    	driver.navigate().to("https://www.browserstack.com/");
    	Boolean verifyTitle = driver.getTitle().equalsIgnoreCase("Most Reliable App & Cross Browser Testing Platform | BrowserStack");
    	assertTrue(verifyTitle);
    	
    
    }
    

    @Test
    public void assertTrueTest() {

        Boolean AvailExText = driver.findElement(By.xpath("//*[@id=\"content\"]/h2")).isDisplayed();

        Assert.assertTrue(AvailExText);
System.out.println(AvailExText);
    }

    @Test
    public void assertFalseTest() {

         //Assert.assertFalse(driver.findElement(By.xpath("//a[normalize-space()='Basic Auth']")).isDisplayed());

        Assert.assertFalse(isEvenNumber(3));

    }

    public boolean isEvenNumber(int number) {

        boolean result = false;
        if (number % 2 == 0) {
            result = true;
        }
        return result;
    }
	
	@After
	public void teardown() {
		
		driver.close();
	}
	
	
	@Test
	public void amazonAssert() {
		   driver.get("https://www.amazon.com");
	        String ActualTitle = driver.getTitle();
	    //    String ExpectedTitle = "Welcome to Amazon";  // incorrect title expectation
	        String ExpectedTitle = "Amazon.com. Spend less. Smile more.";  //correct title expectation
	        Assert.assertEquals(ActualTitle, ExpectedTitle); //hard assertion
	        System.out.println("Assert passed");
	    
	    
	    
	    
	    
	    
		
		
	}
	
	
	
	
	
	
	
}
