package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.WaitsPage;

public class BaseTestCase {
    private WebDriver driver;
    protected WaitsPage waitsPage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        goHome();
        waitsPage = new WaitsPage(driver);
    }

    @BeforeMethod
    public void goHome() {
        driver.get("https://www.selenium.dev/documentation/webdriver/waits/");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
