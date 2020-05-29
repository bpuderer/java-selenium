package basics;


import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// http://www.seleniumhq.org/docs/04_webdriver_advanced.jsp#explicit-and-implicit-waits
public class Waits {

	@Test
	public void testImplicitWait() {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.alaskaair.com/");
		// poll the DOM for a certain amount of time when trying to find an element/elements
		// if not immediately available. Once set, the implicit wait is done for the life of
		// the WebDriver object and when searching for all elements
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);

		driver.findElement(By.cssSelector("#tab-hotels")).click();
		driver.findElement(By.cssSelector("#hotelOnlyToLocation")).sendKeys("NYC");
		driver.findElement(By.cssSelector("#hotelOnlyToLocation")).sendKeys(Keys.TAB);
		driver.findElement(By.cssSelector("#hotelFromDate")).sendKeys(Keys.ENTER);

		driver.quit();
	}
	
	@Test
	public void testExplicitWait() {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.alaskaair.com/");
		driver.findElement(By.cssSelector("#tab-hotels")).click();

		// WebElement hotelsTextInput = (new WebDriverWait(driver, 1)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#hotelOnlyToLocation")));
		// hotelsTextInput.sendKeys("NYC");
		// hotelsTextInput.sendKeys(Keys.TAB);

		// wait for condition before proceeding
		WebDriverWait w = new WebDriverWait(driver, 1);
		w.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#hotelOnlyToLocation")));

		driver.findElement(By.cssSelector("#hotelOnlyToLocation")).sendKeys("NYC");
		driver.findElement(By.cssSelector("#hotelOnlyToLocation")).sendKeys(Keys.TAB);
		driver.findElement(By.cssSelector("#hotelFromDate")).sendKeys(Keys.ENTER);

		driver.quit();
	}
	
}
