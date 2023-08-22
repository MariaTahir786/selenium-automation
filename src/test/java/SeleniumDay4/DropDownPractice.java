package SeleniumDay4;

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

public class DropDownPractice {


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
	public void searchItem() throws InterruptedException {


		List<WebElement>categoryDropdown= driver.findElements(By.xpath("(//*[@id='searchDropdownBox'])[1]"));
		/*
        WebElement categoryDropdown = driver.findElement(By.id("searchDropdownBox"));
        Select dropdown = new Select(categoryDropdown);

        dropdown.selectByVisibleText("Books"); // Selecting "Books" category*/
		Thread.sleep(5000);
		
		System.out.println(categoryDropdown.size()+"categoryDropdownsize");

		for(WebElement listItems:categoryDropdown) {
			
			if(listItems.getText().contains("Amazon Fresh")) {

				listItems.click();
				break;
			}
		}
	}

	@Test
	public void searchItem2() throws InterruptedException {

		Thread.sleep(3000);
		WebElement searchBox= driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		searchBox.sendKeys("tomato");
		Thread.sleep(3000);
		List<WebElement>searchDropdown= driver.findElements(By.xpath("//div[@class='s-suggestion-container' ]//div[@role='button']"));
		System.out.println(searchDropdown.size()+"searchDropdownsize");

		for(WebElement listItems1:searchDropdown) {
			if(listItems1.getText().contains(" paste")) {

				listItems1.click();
				break;
			}

		}

	}

	
	/* 
	 * language drop down example
	 *  public static void main(String[] args) {
	 
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com");

        WebElement languageDropdown = driver.findElement(By.id("icp-nav-flyout"));
        languageDropdown.click();

        WebElement languageOption = driver.findElement(By.cssSelector("span[data-action='es_US']"));
        languageOption.click(); // Selecting Spanish (US) language
        S*/








}
