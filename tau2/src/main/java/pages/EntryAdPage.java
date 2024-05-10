package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EntryAdPage {
    private WebDriver driver;
    private By modalTitle = By.cssSelector("div.modal-title h3");
    private By modalText = By.cssSelector("div.modal-body p");
    private By closeLink = By.cssSelector("div.modal-footer p");
    private By modal = By.className("modal");

    public EntryAdPage(WebDriver driver) {
        this.driver = driver;
        // wait for modal to appear which automatically loads
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(modal)));
    }

    public void clickCloseOnModal() {
        driver.findElement(closeLink).click();
    }

    public String getModalTitle() {
        return driver.findElement(modalTitle).getText();
    }

    public String getModalText() {
        return driver.findElement(modalText).getText();
    }
}
