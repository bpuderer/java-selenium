package basics;

import java.util.Iterator;
import java.util.Set;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class WindowsFrames {

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
	public void switchWindows() {
		
		driver.get("https://twitter.com/signup?lang=en");
		System.out.println(driver.getTitle());	
		WebElement more = driver.findElement(By.linkText("Learn more"));	
		more.click();

		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it = ids.iterator();
		String parent = it.next();
		String child = it.next();

		driver.switchTo().window(child);
		System.out.println(driver.getTitle());		

		driver.switchTo().window(parent);
		System.out.println(driver.getTitle());
	}
	
}
