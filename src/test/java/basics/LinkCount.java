package basics;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LinkCount {

	private static WebDriver driver;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//driver = new ChromeDriver();
		driver = new FirefoxDriver();
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		//driver.quit();
	}
	
	@Test
	public void countLinks() {
		driver.get("https://www.ebay.com");
		
		// links in entire page
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		WebElement footer = driver.findElement(By.id("glbfooter"));
		System.out.println(footer.findElements(By.tagName("a")).size());
		
		WebElement secondColumnFooter = driver.findElement(By.xpath("//*[@id='gf-BIG']/table/tbody/tr/td[2]/ul"));
		List<WebElement> links = secondColumnFooter.findElements(By.tagName("a")); 
		System.out.println(links.size());
		// could have just found particular link in secondColumnFooter rather than iterate
		for (WebElement link : links) {
			System.out.println(link.getText()); // empty for ChromeDriver ???
			if (link.getText().equals("Site map")) {
				System.out.println("found it!");
				link.click();
				break;
			}
		}
		System.out.println(driver.getTitle());
	}
	
}
