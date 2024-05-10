package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NestedFramesPage {
    private WebDriver driver;
    private String bottomFrame = "frame-bottom";
    private String topFrame = "frame-top";
    private String leftFrame = "frame-left";
    private By frameBody = By.tagName("body");

    public NestedFramesPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getBottomFrameText() {
        switchToBottomFrame();
        String text = driver.findElement(frameBody).getText();
        switchToParentFrame();
        return text;
    }

    public String getLeftFrameText() {
        switchToTopFrame();
        switchToLeftFrame();
        String text = driver.findElement(frameBody).getText();
        switchToParentFrame();
        switchToParentFrame();
        return text;
    }

    private void switchToBottomFrame() {
        driver.switchTo().frame(bottomFrame);
    }

    private void switchToTopFrame() {
        driver.switchTo().frame(topFrame);
    }

    private void switchToLeftFrame() {
        // left frame is inside top frame
        driver.switchTo().frame(leftFrame);
    }

    private void switchToParentFrame() {
        driver.switchTo().parentFrame();
    }
}
