package basics;

import static org.junit.Assert.*;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Locators {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("BeforeClass");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("AfterClass");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Before");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("After");
	}
	
	@Test
	public void testLocators() {
		WebDriver driver = new ChromeDriver();

		driver.get("https://en.wikipedia.org/wiki/Main_Page");
		System.out.println(driver.getTitle());

		driver.findElement(By.id("searchInput")).sendKeys("John Cleese");

		driver.findElement(By.id("searchButton")).click();

		// driver.findElement(By.cssSelector("input[id='searchButton']")).click();
		// driver.findElement(By.cssSelector(".searchButton")).click(); // class selector. replace spaces with dots
		// driver.findElement(By.cssSelector("#searchButton")).click(); // id selector

		// driver.findElement(By.xpath("//*[@id='searchButton']")).click();
		// driver.findElement(By.className("searchButton")).click();
		// driver.findElement(By.name("go")).click();

		System.out.println(driver.getTitle());
		assertEquals("John Cleese - Wikipedia", driver.getTitle());

		driver.quit();
	}

}
