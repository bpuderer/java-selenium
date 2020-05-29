package basics;

import static org.junit.Assert.*;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Checkboxes {

	@Test
	public void testCheckbox() {

		WebDriver driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");

		WebElement checkbox = driver.findElement(By.cssSelector("#rememberUn"));
		assertEquals(false, checkbox.isSelected());
		checkbox.click();
		assertEquals(true, checkbox.isSelected());
		
		driver.quit();
	}

}
