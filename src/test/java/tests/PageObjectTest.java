package tests;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.EnglishWikipediaHomePage;
import pages.JohnCleese;

public class PageObjectTest {

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
		EnglishWikipediaHomePage wikiHome = new EnglishWikipediaHomePage(driver);
		wikiHome.search("John Cleese");

		JohnCleese jc = new JohnCleese(driver);
		assertEquals("Weston-super-Mare, Somerset", jc.getBirthplace());
	}
	
}