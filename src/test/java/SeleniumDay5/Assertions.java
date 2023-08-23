package SeleniumDay5;

import java.util.concurrent.TimeUnit;

import org.junit.After;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assertions {

    WebDriver driver;

    @Before
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void invalidLoginCredentials() throws InterruptedException {
        driver.findElement(By.xpath("(//input[@id='email'])[1]")).sendKeys("mma");
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("kjhdhd");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@id='u_0_5_Nm' and @name='login']")).click();
        Thread.sleep(3000);
        WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"email_container\"]/div[2]/text()"));
        String expectedErrorMessage = "The email or mobile number you entered isn’t connected to an account. ";
        String actualErrorMessage = errorMessage.getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message mismatch.");
        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage));
    }

    @After
    public  void tearDown() {
       driver.quit();
    }
}
