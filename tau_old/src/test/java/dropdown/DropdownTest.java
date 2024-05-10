package dropdown;

import base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;


public class DropdownTest extends BaseTest {

    @Test
    public void testSelectOption() {
        var dropdownPage = homePage.clickDropdown();
        String option = "Option 1";
        dropdownPage.selectFromDropdown(option);
        var selectedOptions = dropdownPage.getSelectedOptions();
        assertEquals(selectedOptions.size(), 1);
        assertTrue(selectedOptions.contains(option), "Option 1 not selected");
    }

}
