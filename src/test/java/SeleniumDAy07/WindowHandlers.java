package SeleniumDAy07;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandlers {

	
	static WebDriver driver;
    Actions act;

    @BeforeClass
    public static void setUp() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/browser-windows");
        driver.manage().window().maximize();
        // implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @After
    public void tearDown() {
    driver.close();
    driver.quit();
    }
    @Ignore

    @Test
    public void windowNewTab() throws InterruptedException {
        //clicks on NewTab blue button
        driver.findElement(By.xpath("//*[@id='tabButton']")).click();
        
        //verifies that i am still on homePage
        System.out.println("HomePage -- ToolsQA = "+ driver.getTitle());

        Set<String> ids = driver.getWindowHandles();
        
        Iterator<String> it = ids.iterator();
        
        String homePage = it.next();
        String newTab = it.next();
        
        driver.switchTo().window(newTab);
        
        Thread.sleep(3000);
        System.out.println("NewTab -- https://demoqa.com/sample = " + driver.getCurrentUrl());
        
    }
    @Ignore
     @Test
     public void newWindow() {
    	 driver.findElement(By.xpath("//button[@id='windowButton']")).click();
    	   System.out.println("HomePage -- ToolsQA = "+ driver.getTitle());
    	  
    	 Set<String> ids=driver.getWindowHandles();
         Iterator<String> it = ids.iterator();
         String homePage=it.next();
String newWindowTab=it.next();
    	 
    	 driver.switchTo().window(newWindowTab);
 System.out.println("newWindow"+driver.getCurrentUrl());
    	 
     }
   @Test
   public void windowMessage() {
  	 driver.findElement(By.xpath("//button[@id='messageWindowButton']")).click();
  	 Set<String> ids=driver.getWindowHandles();
  	 Iterator<String> iter=ids.iterator();
     String homePage=iter.next();
  	 String newWindowmeesg=iter.next();
  	 driver.switchTo().window(newWindowmeesg);
  	 System.out.println("newWindowMessage"+driver.getCurrentUrl());
driver.close();
   }
	
}
