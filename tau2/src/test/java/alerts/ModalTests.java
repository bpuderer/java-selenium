package alerts;

import base.BaseTests;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class ModalTests extends BaseTests {

    @Test
    public void testModal() throws InterruptedException {
        var entryAdPage = homePage.clickEntryAd();
        assertEquals(entryAdPage.getModalTitle(), "THIS IS A MODAL WINDOW");
        assertEquals(entryAdPage.getModalText(), "It's commonly used to encourage a user to take an action (e.g., give their e-mail address to sign up for something or disable their ad blocker).");
        entryAdPage.clickCloseOnModal();
    }
}
