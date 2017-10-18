package basics;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class FindElementInFrames {

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
	public void findInFrames() throws InterruptedException {
		driver.get("https://www.google.com/recaptcha/api2/demo");

		By recaptchaCheckbox = By.className("recaptcha-checkbox-checkmark");
		By recaptchaVerify = By.id("recaptcha-verify-button");

		driver.switchTo().frame(findFrameNumberWithElement(recaptchaCheckbox));
		driver.findElement(recaptchaCheckbox).click();

		// not good but frames need to be there before findFrameNumberWithElement
		// searches. if frame was known ahead of time could use
		// WebDriverWait with ExpectedConditions
		// will revisit
		Thread.sleep(3000);

		driver.switchTo().defaultContent();

		driver.switchTo().frame(findFrameNumberWithElement(recaptchaVerify));
		driver.findElement(recaptchaVerify).click();
	}
	
	public int findFrameNumberWithElement(By b) {
		// assumes no frames within frame
		int location = -1;
		for(int i=0; i < driver.findElements(By.tagName("iframe")).size(); i++) {
			driver.switchTo().frame(i);
			if (!driver.findElements(b).isEmpty()) {
				location = i;
				break;
			}
			driver.switchTo().defaultContent();
		}
		driver.switchTo().defaultContent(); // unnecessary if element not found
		System.out.println("frame location: "+location);
		return location;
	}

}
