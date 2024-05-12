package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropPage {
    private WebDriver driver;
    private By leftBox = By.id("column-a");
    private By leftBoxText = By.cssSelector("#column-a header");
    private By rightBox = By.id("column-b");
    private By rightBoxText = By.cssSelector("#column-b header");



    public DragAndDropPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getLeftBoxText() {
        return driver.findElement(leftBoxText).getText();
    }

    public String getRightBoxText() {
        return driver.findElement(rightBoxText).getText();
    }

    public void dragLeftToRight() {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(driver.findElement(leftBox), driver.findElement(rightBox)).perform();
    }

    public void dragRightToLeft() {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(driver.findElement(rightBox), driver.findElement(leftBox)).perform();
    }
}
