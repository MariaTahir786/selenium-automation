package SeleniumDAy07;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssertionsPracticeee {
	
	
	
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
    public void assertTrueTest() {

        Boolean AvailExText = driver.findElement(By.xpath("//*[@id='content']/h2")).isDisplayed();

        Assert.assertTrue(AvailExText);

    }

    @Test
    public void assertFalseTest() {

        // Assert.assertFalse(driver.findElement(By.xpath("//*[@id=\"content\"]/div/button")).isDisplayed());

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
		
		driver.quit();
	}
	

}
