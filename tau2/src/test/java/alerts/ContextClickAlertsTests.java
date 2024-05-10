package alerts;

import base.BaseTests;
import org.testng.annotations.Test;

public class ContextClickAlertsTests extends BaseTests {

    @Test
    public void testContextClickClearAlert() {
        var contextMenu = homePage.clickContextMenu();
        contextMenu.sendContextClickInBox();
        contextMenu.clearAlert();
    }
}
