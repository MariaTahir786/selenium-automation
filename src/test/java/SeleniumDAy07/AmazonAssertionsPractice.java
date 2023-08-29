package SeleniumDAy07;


import java.util.concurrent.TimeUnit;

import org.assertj.core.api.SoftAssertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

// note if assertion shows red line you have to add adependency in pom file juint assertion soft one

public class AmazonAssertionsPractice {

	
	SoftAssertions softAssertions = new SoftAssertions();
	WebDriver driver;
	@Before

	public void openBrowser() {
		WebDriverManager.chromedriver().setup();

		driver=new ChromeDriver();
		driver.manage().window().maximize();

		driver.get(" https://www.amazon.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	@After
	public void tearDown() {
		driver.close();
	}
	
		
		
		 @Test
		    public void softAssertionTest() {
		       
		        
		        // Soft assertions with multiple checks
		        String actualTitle = driver.getTitle();
		        String expectedTitle = "Amazon.com. Spend less. Smile more111111.";
		        softAssertions.assertThat(actualTitle).isEqualTo(expectedTitle);

		        String actualUrl = driver.getCurrentUrl();
		        String expectedUrl = "https://www.amazon.com/111111";
		        softAssertions.assertThat(actualUrl).isEqualTo(expectedUrl);
		        System.out.println("Assertion Failed");
		        String actualHeadingChooseLocation = driver.findElement(By.xpath("//body//div//header//span//a//span[2]")).getText();
		        String expectedHeading = "\r\n"
		        		+ "                   Choose location for most accurate options\r\n"
		        		+ "                ";
		        softAssertions.assertThat(actualHeadingChooseLocation).isEqualTo(expectedHeading);

		        // Additional soft assertions
		        int actualLinkCount = driver.findElements(By.tagName("a")).size();
		        int expectedLinkCount = 518;
		        softAssertions.assertThat(actualLinkCount).isEqualTo(expectedLinkCount);
		        softAssertions.assertThat(actualLinkCount).isEqualTo(expectedLinkCount);
		        boolean isLogoDisplayed = driver.findElement(By.xpath("//a[@aria-label='Amazon']")).isDisplayed();
		        softAssertions.assertThat(isLogoDisplayed).isTrue();

		        System.out.println("All assertions executed");
		    }
	
	
}
