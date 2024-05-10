package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HorizontalSliderPage {

    private WebDriver driver;

    private By horizontalSlider = By.cssSelector("div.sliderContainer input");
    private By sliderRange = By.id("range");

    public HorizontalSliderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void sendRightArrowKeyToSlider() {
        driver.findElement(horizontalSlider).sendKeys(Keys.ARROW_RIGHT);
    }

    public String getRange() {
        return driver.findElement(sliderRange).getText();
    }

}
