package frames;

import base.BaseTests;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class FrameTests extends BaseTests {

    @Test
    public void testWysiwyg() {
        var editorPage = homePage.clickWysiwygEditor();
        editorPage.clearTextArea();
        String text1 = "Hello ";
        String text2 = "world";
        editorPage.setTextArea(text1);
        editorPage.increaseIndent();
        editorPage.setTextArea(text2);
        assertEquals(editorPage.getTextFromEditor(), text1 + text2,
                "Text from editor incorrect");
    }

    @Test
    public void testNestedFrames() {
        var framesPage = homePage.clickFrames();
        var nestedFrames = framesPage.clickNestedFrames();
        assertEquals(nestedFrames.getLeftFrameText(), "LEFT",
                "Left frame text incorrect");
        assertEquals(nestedFrames.getBottomFrameText(), "BOTTOM",
                "Bottom frame text incorrect");
    }

}
