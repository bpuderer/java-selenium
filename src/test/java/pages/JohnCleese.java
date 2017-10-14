package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JohnCleese {

	private WebDriver driver;

	public JohnCleese(WebDriver driver) {
		this.driver = driver;
		if (!driver.getTitle().equals("John Cleese - Wikipedia")) {
			throw new IllegalStateException("This is not the John Cleese Wikipedia page, you're on: " + driver.getTitle());
		}
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@class='birthplace']/a")
	private WebElement birthPlace;
	
	public String getBirthplace() {
		return birthPlace.getText();
	}

}
