package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuPage {
    private WebDriver driver;
    private By box = By.id("hot-spot");

    public ContextMenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public void sendContextClickInBox() {
        WebElement boxElement = driver.findElement(box);
        Actions actions = new Actions(driver);
        actions.contextClick(boxElement).perform();
    }

    public void clearAlert() {
        driver.switchTo().alert().accept();
    }

}
