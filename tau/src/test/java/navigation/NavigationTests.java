package navigation;

import base.BaseTests;
import org.testng.annotations.Test;


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
}
