package dragdrop;

import base.BaseTests;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class DragAndDropTests extends BaseTests {

    @Test
    public void testDragAndDrop() {
        var dnd = homePage.clickDragAndDrop();
        assertEquals(dnd.getLeftBoxText(), "A");
        assertEquals(dnd.getRightBoxText(), "B");
        dnd.dragLeftToRight();
        assertEquals(dnd.getLeftBoxText(), "B");
        assertEquals(dnd.getRightBoxText(), "A");
        dnd.dragLeftToRight();
        assertEquals(dnd.getLeftBoxText(), "A");
        assertEquals(dnd.getRightBoxText(), "B");
        dnd.dragRightToLeft();
        assertEquals(dnd.getLeftBoxText(), "B");
        assertEquals(dnd.getRightBoxText(), "A");
    }
}
