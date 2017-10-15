package basics;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class ActionsEx {

	private static WebDriver driver;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		driver = new ChromeDriver();
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.quit();
	}
	
	@Test
	public void basicTest() {
		driver.get("https://en.wikipedia.org/wiki/Main_Page");
		driver.manage().window().maximize();
		
		WebElement viewSource = driver.findElement(By.linkText("View source"));
		WebElement searchInput = driver.findElement(By.id("searchInput"));
		
		Actions a = new Actions(driver);
		// click in search field, hold Shift, enter "python", double click to select "python"
		a.moveToElement(searchInput).click().keyDown(Keys.SHIFT).sendKeys("python").doubleClick().build().perform();
		a.moveToElement(viewSource).contextClick().build().perform();
	}
	
}
