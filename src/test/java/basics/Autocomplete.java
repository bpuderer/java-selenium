package basics;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// http://www.seleniumeasy.com/selenium-tutorials/working-with-ajax-or-jquery-auto-complete-text-box-using-webdriver
public class Autocomplete {

	private static WebDriver driver;
	private static WebDriverWait wait;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 3);
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		//driver.quit();
	}
	
	@Test
	public void autocompleteSuggestions() {	
		By tagText = By.id("tags");
		By demoFrame = By.cssSelector("iframe.demo-frame");
		
		driver.get("http://jqueryui.com/autocomplete/");
		driver.switchTo().frame(driver.findElement(demoFrame));

		wait.until(ExpectedConditions.presenceOfElementLocated(tagText));
		driver.findElement(tagText).sendKeys("a");
		
		selectOption("Erlang");
	}
	
	public void selectOption(String target) {
		WebElement autoOptions = driver.findElement(By.id("ui-id-1"));
		wait.until(ExpectedConditions.visibilityOf(autoOptions));
		
		List<WebElement> options = autoOptions.findElements(By.tagName("li"));
		for (WebElement option : options) {
			if(option.getText().equals(target)) {
				option.click();
				break;
			}
		}		
	}
	
}
