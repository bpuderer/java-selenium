package basics;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Locators {
	
	@Before
	public void setup() {
		System.out.println("Before!");
	}
	
	@After
	public void tearDown() {
		System.out.println("After!");
	}
	
	@Test
	public void testLocators() {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://en.wikipedia.org/wiki/Main_Page");
		System.out.println(driver.getTitle());
		
		driver.findElement(By.id("searchInput")).sendKeys("John Cleese");
		
		driver.findElement(By.id("searchButton")).click();
		// driver.findElement(By.xpath("//*[@id=\"searchButton\"]")).click();
		// driver.findElement(By.className("searchButton")).click();
		// driver.findElement(By.name("go")).click();

		System.out.println(driver.getTitle());
		Assert.assertEquals("John Cleese - Wikipedia", driver.getTitle());
		
		driver.quit();
	}

}
