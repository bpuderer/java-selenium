package alerts;

import base.BaseTests;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class AlertsTests extends BaseTests {

    @Test
    public void testAcceptAlert() {
        var alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerAlert();
        alertsPage.alert_clickToAccept();
        assertEquals(alertsPage.getResult(),
                "You successfully clicked an alert", "Result text incorrect");
    }

    @Test
    public void testGetTextFromAlert() {
        var alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerConfirm();
        String alertText = alertsPage.alert_getText();
        alertsPage.alert_clickToDismiss();
        assertEquals(alertText, "I am a JS Confirm");
        assertEquals(alertsPage.getResult(), "You clicked: Cancel");
    }

    @Test
    public void testEnterTextAlert() {
        var alertsPage = homePage.clickJavaScriptAlerts();
        String testString = "TAU rocks!";
        alertsPage.triggerPrompt();
        alertsPage.alert_setInput(testString);
        alertsPage.alert_clickToAccept();
        assertEquals(alertsPage.getResult(), "You entered: " + testString, "Results string incorrect");
    }

}
