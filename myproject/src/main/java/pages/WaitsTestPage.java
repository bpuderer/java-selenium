package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitsTestPage {

    private WebDriver driver;
    private By addBoxButton = By.id("adder");
    private By revealInputButton = By.id("reveal");
    private By box = By.id("box0");
    private By revealedInput = By.id("revealed");

    public WaitsTestPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddBox() {
        driver.findElement(addBoxButton).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(box));
    }

    public void clickRevealInput() {
        driver.findElement(revealInputButton).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(revealedInput)));
    }

    public void enterTextInRevealedInput(String text) {
        if (hasInputBeenRevealed()) {
            driver.findElement(revealedInput).sendKeys(text);
        }
    }

    public boolean isBoxDisplayed() {
        return !driver.findElements(box).isEmpty();
    }

    public boolean hasInputBeenRevealed() {
        return driver.findElement(revealedInput).isDisplayed();
    }
}
