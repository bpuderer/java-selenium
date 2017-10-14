package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnglishWikipediaHomePage {

	private WebDriver driver;

	public EnglishWikipediaHomePage(WebDriver driver) {
		this.driver = driver;
		if (!driver.getTitle().equals("Wikipedia, the free encyclopedia")) {
			throw new IllegalStateException("This is not the English Wikipedia home page, you're on: " + driver.getTitle());
		}
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="searchInput")
	private WebElement searchInput;
	
	@FindBy(id="searchButton")
	private WebElement searchButton;

	public void search(String s) {
		searchInput.sendKeys(s);
		searchButton.click();
	}	
	
}