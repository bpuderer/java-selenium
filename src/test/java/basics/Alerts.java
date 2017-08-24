package basics;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {

	@Test
	public void testRadioButton() {
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.javascripter.net/faq/alert.htm");
		driver.findElement(By.xpath("//input[@value='Try it now']")).click();

		// Alert
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		
		driver.quit();
	}
	
}
