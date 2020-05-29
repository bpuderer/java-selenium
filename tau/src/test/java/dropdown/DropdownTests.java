package dropdown;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;


public class DropdownTests extends BaseTests {

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
