package basics;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableEx {
	
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
	public void parseTable() {
		driver.get("http://www.espn.com/nfl/standings");
		
		// locator should use element with conference name
		WebElement afcStandingsTable = driver.findElements(By.cssSelector(".standings.has-team-logos")).get(0);
		List<WebElement> teams = afcStandingsTable.findElements(By.tagName("tr"));
		
		for(WebElement team : teams) {	
			List<WebElement> columns = team.findElements(By.tagName("td"));
			for (WebElement column : columns) {
				System.out.println(column.getText());
			}	
		}
		
	}

}
