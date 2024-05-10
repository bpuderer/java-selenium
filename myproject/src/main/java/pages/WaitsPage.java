package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WaitsPage {
    private WebDriver driver;
    private By linkToTestPage = By.linkText("https://www.selenium.dev/selenium/web/dynamic.html");

    public WaitsPage(WebDriver driver) {
        this.driver = driver;
    }

    public WaitsTestPage clickTestPageLink() {
        driver.findElement(linkToTestPage).click();
        return new WaitsTestPage(driver);
    }

}
