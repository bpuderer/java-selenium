package basics;


import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class CalendarEx {

	private static WebDriver driver;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		driver = new ChromeDriver();
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		//driver.quit();
	}
	
	@Test
	public void basicTest() throws InterruptedException {
		driver.get("https://www.southwest.com");
		
		WebElement depart = driver.findElement(By.id("air-date-departure"));
		depart.click();

		Thread.sleep(200);

		By monthYear = By.xpath("//div[@class='calendar-1 js-calendar-1']//h3");
		By rightArrow = By.xpath("//div[@class='calendar-2 js-calendar-2']/a");
		
		while(!driver.findElement(monthYear).getText().equals("May 2018")) {
			driver.findElement(rightArrow).click();
		}		
		
		List<WebElement> days = driver.findElements(By.xpath("//div[@class='calendar-1 js-calendar-1']//td"));	
		for (WebElement day : days) {
			if (day.getText().equals("20")) {
				day.click();
				break;
			}
		}	

	}
	
}
