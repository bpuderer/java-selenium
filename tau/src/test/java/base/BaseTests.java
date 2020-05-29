package base;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.EventReporter;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

// https://www.javadoc.io/doc/org.seleniumhq.selenium/selenium-api/3.141.59/org/openqa/selenium/WebDriver.html
// https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-chrome-driver/3.141.59
// https://the-internet.herokuapp.com/
// Chrome F12, ^F

public class BaseTests {

    //private WebDriver driver;
    private EventFiringWebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        // driver = new ChromeDriver();
        //driver = new EventFiringWebDriver(new ChromeDriver());
        driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
        driver.register(new EventReporter());

        //driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        //driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
        // see DynamicLoadingExample1Page for explicit wait example
        // implicit wait applies to all elements - generally a bad idea.  don't use
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        goHome();
        setCookie();
    }

    @BeforeMethod
    public void goHome()
    {
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    public WindowManager getWindowManager() {
        return new WindowManager(driver);
    }

    @AfterMethod
    public void recordFailure(ITestResult result) {

        if (ITestResult.FAILURE == result.getStatus()) {

            var camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);

            String timestamp = new SimpleDateFormat("yyyy-MM-dd'T'HHmmss.SSS").format(new Date());
            String filename = "resources/screenshots/" + result.getName() + timestamp + ".png";
            try {
                Files.move(screenshot.toPath(), new File(filename).toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    // TODO: add takeScreenshot() method which can be called from test and use method name in filename

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        //options.setHeadless(true);
        return options;
    }

    private void setCookie() {
        Cookie cookie = new Cookie.Builder("tau", "123")
                .domain("the-internet.herokuapp.com")
                .build();
        // See cookies with F12, Application, Storage > Cookies
        driver.manage().addCookie(cookie);
    }
}
