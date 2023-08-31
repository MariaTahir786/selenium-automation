package Selenium_51TestCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HomepageTests {

	WebDriver driver;

	@BeforeClass
	public static void beforeClass() {
		System.out.println("Before class");
	}

	@Before
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://practice.automationtesting.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() {
		//driver.close();
		}
	
	//test case1
	@Test
	public void homehasThreeSliders() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='menu-item-40']/a")).click();
		Thread.sleep(10000);
//		driver.switchTo().frame(driver.findElement(By.id("aswift_0")));
//        driver.switchTo().frame(driver.findElement(By.id("ad_iframe")));
//        
//        driver.findElement(By.xpath("//div[@id='dismiss-button']/div/span")).click();
//        driver.switchTo().defaultContent();
    
		
		driver.findElement(By.xpath(" //a[normalize-space()='Home']")).click();

		//this is the xpath for sliders and list of elements

		List<WebElement>slidersHomepage=driver.findElements(By.xpath("//*[@class='n2-ss-slider-3']/div"));
		System.out.println("hi");
		//loop through it to get size of list  
		for(int i=1;i<=slidersHomepage.size();i++) {


			int slidersize=slidersHomepage.size();

			// hard assertion 
			Assert.assertEquals(3, slidersize);



		}System.out.println("Assert passed,  Home page has three sliders only");

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ; 
		//driver.findElements(By.xpath(""))

	}
/*
	//test case2
	@Test
	public void homePagehasThreeArrivals() {
		driver.findElement(By.xpath("//*[@id='menu-item-40']/a")).click();
		driver.findElement(By.xpath("//div[@id='content']//a")).click();


		List<WebElement> newarrivals=driver.findElements(By.xpath("//div[@class='themify_builder_sub_row clearfix gutter-default   sub_row_1-0-2']/div"));

		// The Home page must contains only three Arrivals
		for (int i = 1; i <= newarrivals.size(); i++) {
			int arrivalSize= newarrivals.size();
			//check if home page has three arrivals
			Assert.assertEquals(3, arrivalSize);
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		System.out.println("Home  page has three arrivals only");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);}

	/////////test case3
	@Ignore
	@Test
	public void homePageImagesNavigate() throws InterruptedException {
		
		this.homePagehasThreeArrivals();
		Thread.sleep(3000);
		
	
		//check if the link for the first item works
		WebElement newArrival1 = driver.findElement(By.xpath("//*[@title='Selenium Ruby']"));
		newArrival1.click();
		String newArrival1WindowURL = driver.getCurrentUrl();
		Assert.assertEquals("http://practice.automationtesting.in/product/selenium-ruby/", newArrival1WindowURL);
		driver.navigate().back();

		//check if the link for the second item works
		WebElement newArrival2 = driver.findElement(By.xpath("//*[@title='Thinking in HTML']"));
		newArrival2.click();
		String newArrival2WindowURL = driver.getCurrentUrl();
		Assert.assertEquals("http://practice.automationtesting.in/product/thinking-in-html/", newArrival2WindowURL);
		driver.navigate().back();

		//check if the link for the third item works
		WebElement newArrival3 = driver.findElement(By.xpath("//*[@title='Mastering JavaScript']"));
		newArrival3.click();
		String newArrival3WindowURL = driver.getCurrentUrl();
		Assert.assertEquals("http://practice.automationtesting.in/product/mastering-javascript/", newArrival3WindowURL);
	}	


	
	//test case 4
	
	@Ignore
	@Test
	public void imageDescription()throws InterruptedException {
		
		
		this.homePagehasThreeArrivals();
		Thread.sleep(3000);
		
		//check if the link for the first item works
				WebElement newArrival1 = driver.findElement(By.xpath("//*[@title='Selenium Ruby']"));
				newArrival1.click();
				
				String newArrival1WindowURL = driver.getCurrentUrl();
				Assert.assertEquals("http://practice.automationtesting.in/product/selenium-ruby/", newArrival1WindowURL);
				WebElement descriptionBox1=driver.findElement(By.xpath("//*[@class='description_tab active']"));
				descriptionBox1.click();
				Boolean description1=driver.findElement(By.xpath("//*[@id=\"tab-description\"]")).isDisplayed();
				Assert.assertTrue(description1);
				driver.navigate().back();

				//check if the link for the second item works
				WebElement newArrival2 = driver.findElement(By.xpath("//*[@title='Thinking in HTML']"));
				newArrival2.click();
				String newArrival2WindowURL = driver.getCurrentUrl();
				Assert.assertEquals("http://practice.automationtesting.in/product/thinking-in-html/", newArrival2WindowURL);
				WebElement descriptionBox2=driver.findElement(By.xpath("//*[@id=\"product-163\"]/div[3]/ul/li[1]"));
				descriptionBox2.click();
				Boolean description2=driver.findElement(By.xpath("//*[@id=\"tab-description\"]")).isDisplayed();
				Assert.assertTrue(description2);
				driver.navigate().back();

				//check if the link for the third item works
				WebElement newArrival3 = driver.findElement(By.xpath("//*[@title='Mastering JavaScript']"));
				newArrival3.click();
				String newArrival3WindowURL = driver.getCurrentUrl();
				Assert.assertEquals("http://practice.automationtesting.in/product/mastering-javascript/", newArrival3WindowURL);
				WebElement descriptionBox3=driver.findElement(By.xpath("//*[@id=\"product-165\"]/div[3]/ul/li[1]"));
				descriptionBox3.click();
				Boolean description3=driver.findElement(By.xpath("//*[@id=\"tab-description\"]")).isDisplayed();
				Assert.assertTrue(description3);
	}


@Ignore
	//Test case5
				@Test
				public void imageReview()throws InterruptedException {
					
					
					this.homePagehasThreeArrivals();
					Thread.sleep(3000);
					//check if the link for the first item works
					WebElement newArrival1 = driver.findElement(By.xpath("//*[@title='Selenium Ruby']"));
					newArrival1.click();
					
					String newArrival1WindowURL = driver.getCurrentUrl();
					Assert.assertEquals("http://practice.automationtesting.in/product/selenium-ruby/", newArrival1WindowURL);
					WebElement reviewBox1=driver.findElement(By.xpath("//*[@id=\"product-160\"]/div[3]/ul/li[2]"));
					reviewBox1.click();
					Boolean review1=driver.findElement(By.xpath("//*[@id=\"reviews\"]")).isDisplayed();
					Assert.assertTrue(review1);
					driver.navigate().back();

					//check if the link for the second item works
					WebElement newArrival2 = driver.findElement(By.xpath("//*[@title='Thinking in HTML']"));
					newArrival2.click();
					String newArrival2WindowURL = driver.getCurrentUrl();
					Assert.assertEquals("http://practice.automationtesting.in/product/thinking-in-html/", newArrival2WindowURL);
					WebElement reviewBox2=driver.findElement(By.xpath("//*[@id=\"product-163\"]/div[3]/ul/li[2]"));
					reviewBox2.click();
					Boolean review2=driver.findElement(By.xpath("//*[@id=\"reviews\"]")).isDisplayed();
					Assert.assertTrue(review2);
					driver.navigate().back();

					//check if the link for the third item works
					WebElement newArrival3 = driver.findElement(By.xpath("//*[@title='Mastering JavaScript']"));
					newArrival3.click();
					String newArrival3WindowURL = driver.getCurrentUrl();
					Assert.assertEquals("http://practice.automationtesting.in/product/mastering-javascript/", newArrival3WindowURL);
					WebElement reviewBox3=driver.findElement(By.xpath("//*[@id=\"product-165\"]/div[3]/ul/li[2]"));
					reviewBox3.click();
					Boolean review3=driver.findElement(By.xpath("//*[@id=\"reviews\"]")).isDisplayed();
					Assert.assertTrue(review3);
					
				}	

	
				@Test
				public void arrivalImageAddToBasket()throws InterruptedException {
					this.homePagehasThreeArrivals();
					Thread.sleep(3000);
					//check if the link for the second item works
					WebElement newArrival2 = driver.findElement(By.xpath("//*[@title='Thinking in HTML']"));
					newArrival2.click();
					String newArrival2WindowURL = driver.getCurrentUrl();
					Assert.assertEquals("http://practice.automationtesting.in/product/thinking-in-html/", newArrival2WindowURL);
					driver.findElement(By.xpath("//img[@title=\"HTML5 Web Application Development Beginner's guide\"]")).click();
					driver.findElement(By.xpath("//button[@type='submit']")).click();
					boolean cartDisplay=driver.findElement(By.xpath("//a[@title='View your shopping cart']")).isDisplayed();

					
					Assert.assertTrue(cartDisplay);
					
				
				}
				
				@Test
				public void arrivalImageAddMoreToBasket()throws InterruptedException {
					
					this.arrivalImageAddToBasket();
					Thread.sleep(3000);
					
				WebElement inputqty=driver.findElement(By.xpath("//input[@title='Qty']"));
				inputqty.clear();
				inputqty.sendKeys("9056");
				//WebElement ele = driver.findElement(By.xpath("//form/div/input"));
//	            JavascriptExecutor js = (JavascriptExecutor) driver;
//	            Boolean isValidInput = (Boolean)js.executeScript("return arguments[0].checkValidity();", ele);
//	            System.out.println(isValidInput);
//	            String validationMessage = (String)js.executeScript("return arguments[0].validationMessage;", ele);
//	            System.out.println(validationMessage);
//	            
//	            Assert.assertFalse(isValidInput);
//
//	            String alert = String.format("Value must be less than or equal to %d.", Integer.valueOf(getMax));
//	            
//	            Assert.assertTrue(validationMessage.equals(alert));
//				
					 
//need to find which book is this 
					String getMax = driver.findElement(By.xpath("//*[@class='quantity']/input ")).getAttribute("Max");
			        System.out.println(getMax);
			        int moreThanMax = Integer.valueOf(getMax)+1;
		            
		            driver.findElement(By.xpath("//form/div/input")).clear();
		            driver.findElement(By.xpath("//form/div/input")).sendKeys(String.valueOf(moreThanMax));
		            driver.findElement(By.xpath("//button[contains(text(), 'Add to basket')]")).click();
		            
		            //Check if there is an error message pop up (using javascript)
		            WebElement ele = driver.findElement(By.xpath("//form/div/input"));
		            JavascriptExecutor js = (JavascriptExecutor) driver;
		            Boolean isValidInput = (Boolean)js.executeScript("return arguments[0].checkValidity();", ele);
		            System.out.println(isValidInput);
		            String validationMessage = (String)js.executeScript("return arguments[0].validationMessage;", ele);
		            System.out.println(validationMessage);
		            
		            Assert.assertFalse(isValidInput);

		            String alert = String.format("Value must be less than or equal to %d.", Integer.valueOf(getMax));
		            
		            Assert.assertTrue(validationMessage.equals(alert));
//					
				}
				
	
	
	*/
	
	
	
	
	
}
