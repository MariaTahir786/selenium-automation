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
		WebElement target2=driver.findElement(By.xpath("//*[@id='notGreedyInnerDropBox']"));
		  // Locate the draggable element
		int initialX = source2.getLocation().getX();
        int initialY = source2.getLocation().getY();

        //locate target location
        int targetX = target2.getLocation().getX();
        int targetY = target2.getLocation().getY();

		System.out.println(initialX);
		
		System.out.println(initialY);
		System.out.println(targetX);
		
		System.out.println(targetY);
		
		act.dragAndDrop(source2, target2).build().perform();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		 // Revert the element back to its initial position
        act.dragAndDropBy(source2, initialX - targetX, initialY - targetY).perform();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
      /*  
        // Capture positions after reverting
        int revertedX = source2.getLocation().getX();
        int revertedY = source2.getLocation().getY();

        // Assert that the element has been reverted to its initial position
        Assert.assertEquals(initialX, revertedX);
        Assert.assertEquals(initialY, revertedY);
    
        Assert.assertEquals(initialX, revertedX);
        Assert.assertEquals(initialY, revertedY);
		System.out.println("prevent worked");
	
		/*
		 *     // Locate the draggable element
        WebElement draggableElement = driver.findElement(By.id("draggable"));

        // Capture the initial position of the draggable element
        int initialX = draggableElement.getLocation().getX();
        int initialY = draggableElement.getLocation().getY();

        // Initialize the Actions object
        Actions actions = new Actions(driver);

        // Perform the drag-and-drop operation (move to a new location)
        int targetX = 200;
        int targetY = 200;
        actions.dragAndDropBy(draggableElement, targetX - initialX, targetY - initialY).perform();

        // Revert the element back to its initial position
        actions.dragAndDropBy(draggableElement, initialX - targetX, initialY - targetY).perform();

        // Close the WebDriver
        driver.quit();
    } * */
        
		
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
