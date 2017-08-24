package basics;

import java.util.List;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class RadioButtons {


	@Test
	public void testRadioButton() {
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.echoecho.com/htmlforms10.htm");
		WebElement cheeseRadioButton = driver.findElement(By.xpath("//input[@value='Cheese']"));
		System.out.println(cheeseRadioButton.isSelected());
		cheeseRadioButton.click();
		System.out.println(cheeseRadioButton.isSelected());
		
		List<WebElement> groupOneButtons = driver.findElements(By.xpath("//input[@name='group1']"));
		System.out.println(groupOneButtons.size());
		for (WebElement button : groupOneButtons) {
			if (button.getAttribute("value").equals("Butter")) {
				button.click();
			}
		}
		
		driver.quit();
	}

}
