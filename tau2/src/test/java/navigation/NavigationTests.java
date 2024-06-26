package navigation;

import base.BaseTests;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class NavigationTests extends BaseTests {

    @Test
    public void testNavigator() {
        homePage.clickDynamicLoading().clickExample1();
        // tests don't have access to the WebDriver to create WindowManager
        // access to WindowManager added to BaseTests
        getWindowManager().goBack();
        getWindowManager().refreshPage();
        getWindowManager().goForward();
        getWindowManager().goTo("https://google.com");
    }

    @Test
    public void testSwitchTab() {
        homePage.clickMultipleWindows().clickHere();
        getWindowManager().switchToTab("New Window");
    }

    @Test
    public void testOpenLinkNewTab() {
        var example2 = homePage.clickDynamicLoading().rightClickOnExample2();
        getWindowManager().switchToNewTab();
        assertTrue(example2.isStartButtonDisplayed(), "Start button not displayed");
    }
}
