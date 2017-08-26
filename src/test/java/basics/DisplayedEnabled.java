package basics;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class DisplayedEnabled {

	@Test
	public void testNotEnabled() {
		
		// to check if element not present, findElements() and check size == 0
		// https://stackoverflow.com/a/9188374
		
		// to check if hidden or disabled: isDisplayed(), isEnabled()
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.southwest.com/");
		WebElement returnDate = driver.findElement(By.cssSelector("#air-date-return"));
		WebElement returnDateLabel = driver.findElement(By.cssSelector(".js-return-date-label.booking-form--label.booking-form--date-container-label")); 
		
		assertTrue(returnDate.isEnabled());
		assertTrue(!returnDateLabel.getText().isEmpty());
		
		// clicking one-way disables return date
		driver.findElement(By.cssSelector("#trip-type-one-way")).click();
		assertFalse(returnDate.isEnabled());
		assertTrue(returnDateLabel.getText().isEmpty());
		
		// clicking round trip re-enables return date
		driver.findElement(By.cssSelector("#trip-type-round-trip")).click();
		assertTrue(returnDate.isEnabled());
		assertTrue(!returnDateLabel.getText().isEmpty());
		
		
		driver.findElement(By.cssSelector("#air-pax-count-adults")).click();
		for (int i=0; i < 3; i++) {
			driver.findElement(By.cssSelector("#jb-number-selector-more")).click();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		assertEquals(4, Integer.parseInt(driver.findElement(By.cssSelector(".js-number-selector-value.number-selector--value")).getText()));
		
		driver.quit();
	}
	
}
