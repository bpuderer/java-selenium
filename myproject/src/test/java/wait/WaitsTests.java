package wait;

import base.BaseTestCase;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class WaitsTests extends BaseTestCase {

    @Test
    public void testBoxAddedToDom() {
        var testPage = waitsPage.clickTestPageLink();
        assertFalse(testPage.isBoxDisplayed());
        testPage.clickAddBox();
        assertTrue(testPage.isBoxDisplayed());
    }

    @Test
    public void testInputBecomesVisible() {
        var testPage = waitsPage.clickTestPageLink();
        assertFalse(testPage.hasInputBeenRevealed());
        testPage.clickRevealInput();
        assertTrue(testPage.hasInputBeenRevealed());
    }
}
