package basics;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdowns {

	@Test
	public void testStaticDropdown() {

		WebDriver driver = new ChromeDriver();
		driver.get("https://developer.mozilla.org/en-US/docs/Web/HTML/Element/select");

		Select select = new Select(driver.findElement(By.xpath("//select")));
		select.selectByValue("value3");
		select.selectByIndex(1);
		select.selectByVisibleText("Value 3");
		Assert.assertEquals("Value 3", select.getFirstSelectedOption().getText());

		driver.quit();
	}

}
