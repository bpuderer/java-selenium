package basics;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Screenshot {

	@Test
	public void testTakeScreenshot() {

		WebDriver driver = new ChromeDriver();
		driver.get("https://en.wikipedia.org/wiki/Eric_Idle");

		// https://stackoverflow.com/a/3423347
		// by Sergii Pozharov
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File("screenshots/screenshot.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.quit();
	}
	
}
