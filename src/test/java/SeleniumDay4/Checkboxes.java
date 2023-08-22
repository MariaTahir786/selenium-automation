package SeleniumDay4;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Checkboxes {

	// this is first one text box 
	WebDriver driver;
	@BeforeClass
	public static void beforeClass() {System.out.println("Before Class method");}

	@Before
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();

		driver.get("https://demoqa.com/");
		driver.manage().window().maximize();

	}
	@After
	public void tearDown() {
		driver.close();
	}

	@Test
	public void checkBoxText()  {

		WebElement elementPage=driver.findElement(By.xpath("//*[contains(@class,'card mt-4 top-card')]"));

		elementPage.click();

		WebElement textBox=driver.findElement(By.xpath("//*[@class='btn btn-light ' and @id='item-0']"));
		textBox.click();
		WebElement userName=driver.findElement(By.xpath("//*[@id='userName']"));
		userName.sendKeys("Maria Tahir");

		WebElement emailBox=driver.findElement(By.xpath("//*[@id='userEmail']"));
		emailBox.sendKeys("abc@gmail.com");
		WebElement addressA=driver.findElement(By.xpath("//*[@id='currentAddress']"));
		addressA.sendKeys("1213 resdfgt,woodland");
		WebElement permanenetAddress=driver.findElement(By.xpath("//*[@id='permanentAddress']"));

		permanenetAddress.sendKeys("same as above");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


		WebElement submitButton=driver.findElement(By.xpath("//button[contains(@id,'submit' )]"));

		submitButton.submit();

	}
	@Test
	public void checkingCheckBoxes() {
		WebElement elementPage=driver.findElement(By.xpath("//*[contains(@class,'card mt-4 top-card')]"));

		elementPage.click();
		WebElement checkBoxPage=driver.findElement(By.xpath("//div[@class='element-list collapse show']//li[@id='item-1']"));
		checkBoxPage.click();
		System.out.println(checkBoxPage.isSelected());
		WebElement Hometoggler=driver.findElement(By.xpath("//button[@title='Toggle']//*[name()='svg']"));
		Hometoggler.click();
		WebElement desktopToggler=driver.findElement(By.xpath("(//button[@title='Toggle']//*[name()='svg'])[2]"));
		desktopToggler.click();
		WebElement NotesCheckbox=driver.findElement(By.xpath("(//*[@class='rct-title' and contains(text(),Notes)])[3]"));
		NotesCheckbox.click();
		System.out.println(NotesCheckbox.isSelected()+"Note Checkbox Selected");
	}



	@Test
	public void aradioButton() {
		WebElement elementPage =driver.findElement(By.xpath("//*[contains(@class,'card mt-4 top-card')]"));
		elementPage.click();
		WebElement radioButtonPage=driver.findElement(By.xpath("(//*[@id='item-2' and @class=\"btn btn-light \" ])[1]"));
		radioButtonPage.click();
		Boolean isYesBoxSelected = driver
				.findElement(By.xpath("//div[@id='app']/div/div/div[2]/div[2]/div[2]/div[2]/label")).isSelected();

		Boolean isImpressiveBoxSelected = driver
				.findElement(By.xpath("//div[@id='app']/div/div/div[2]/div[2]/div[2]/div[3]/label")).isSelected();

		Boolean isNoBoxEnabled = driver
				.findElement(By.xpath("//*[@id=\"noRadio\"]")).isEnabled();

		if (isYesBoxSelected) {
			driver.findElement(By.xpath("//div[@id='app']/div/div/div[2]/div[2]/div[2]/div[2]/label")).click();
		} else {
			System.out.println("The Yes box is default unchecked");
		}

		if (isImpressiveBoxSelected) {
			driver.findElement(By.xpath("//div[@id='app']/div/div/div[2]/div[2]/div[2]/div[3]/label")).click();

		} else {
			System.out.println("The Impressive box is default unchecked");
		}

		if (isNoBoxEnabled) {
			System.out.println("The No box is default enabled");

		} else {
			System.out.println("The No box is default disabled");
		}



		driver.findElement(By.xpath("//div[@id='app']/div/div/div[2]/div[2]/div[2]/div[3]/label")).click();

		Boolean textMessage =driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/p")).isDisplayed();

		if(textMessage) {
			System.out.println("good job");
		}
	}



}
