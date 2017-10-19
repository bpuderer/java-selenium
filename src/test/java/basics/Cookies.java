package basics;

import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cookies {
	
	private static WebDriver driver;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		driver = new ChromeDriver();
	}
	
	@After
	public void cleanUp() throws Exception {
		driver.manage().deleteAllCookies();
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.quit();
	}
	
	@Test
	public void basicTest() {
		driver.get("https://www.apple.com");
		Set<Cookie> cookies = driver.manage().getCookies();
		System.out.println(cookies.size());
		for(Cookie cookie : cookies) {
			System.out.println(cookie);
		}
	}

}
