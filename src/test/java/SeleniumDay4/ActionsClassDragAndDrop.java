package SeleniumDay4;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsClassDragAndDrop {


	WebDriver driver;
	Actions act;

	@Before
	public void setUp() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/droppable/");
		driver.manage().window().maximize();
		// implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void simpleDragAndDrop() {
		act = new Actions(driver);

		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));

		act.dragAndDrop(source, target).build().perform();

	}
	@After
	public void teardown() {
		driver.close();
	}


	@Test
	public void acceptDragAndDrop() throws InterruptedException {
		act = new Actions(driver);
		driver.findElement(By.id("droppableExample-tab-accept")).click();

		WebElement source1 = driver.findElement(By.id("acceptable"));
		WebElement target1 = driver.findElement(By.xpath("//*[@id='droppableContainer']/div/div[2]/div/div[2]"));
		WebElement sour1=driver.findElement(By.xpath("//div[@id='notAcceptable']"));
		act.dragAndDrop(source1, target1).build().perform();
		act.dragAndDrop(sour1, target1).build().perform();
		System.out.println("accept worked");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void preventPropoDragAndDrop() throws InterruptedException {
		act = new Actions(driver);
		driver.findElement(By.xpath("//a[@id='droppableExample-tab-preventPropogation']")).click();
		Thread.sleep(3000);
		WebElement source2 = driver.findElement(By.xpath("//*[@id='ppDropContainer']/div[@id='dragBox']"));
		WebElement target2=driver.findElement(By.xpath("//*[@id='greedyDropBoxInner']"));
		act.dragAndDrop(source2, target2).build().perform();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("prevent worked");

	}
	@Test
	public void revertDraggableDragAndDrop() throws InterruptedException {
		act = new Actions(driver);
		driver.findElement(By.xpath("//a[@id='droppableExample-tab-revertable']")).click();
		Thread.sleep(3000);
		WebElement source3 = driver.findElement(By.xpath("//*[@id='revertableDropContainer']/div/div"));
		WebElement target3=driver.findElement(By.xpath("//*[@id='revertableDropContainer' ]/div[2]"));
		act.dragAndDrop(source3, target3).build().perform();
		System.out.println("revert worked fine");


	}
}
