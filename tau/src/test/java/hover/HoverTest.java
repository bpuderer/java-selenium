package hover;

import base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class HoverTest extends BaseTest {

    @Test
    public void testHoverUse1() {
        var hoversPage = homePage.clickHovers();
        var caption = hoversPage.hoverOverFigure(1);
        assertTrue(caption.isCaptionDisplayed());
        assertEquals(caption.getTitle(), "name: user1");
        assertTrue(caption.getLink().endsWith("/users/1"));
        assertEquals(caption.getLinkText(), "View profile");
    }

}
