package basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.firefox.FirefoxDriver;

public class HelloWorld {

	public static void main(String[] args) {
		// geckodriver must be in path
		// https://github.com/mozilla/geckodriver/releases
		
		// chromedriver must be in path
		// https://github.com/SeleniumHQ/selenium/wiki/ChromeDriver
		
		// WebDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.quit();
	}

}
