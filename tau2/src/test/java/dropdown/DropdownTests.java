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
        assertEquals(selectedOptions.size(), 1,
                "Incorrect number of selections");
        assertTrue(selectedOptions.contains(option), "Option was not selected");
    }

    @Test
    public void testMultipleSelectOptions() {
        var dropdownPage = homePage.clickDropdown();
        String option1 = "Option 1";
        String option2 = "Option 2";

        dropdownPage.enableMultiSelect();
        dropdownPage.selectFromDropdown(option1);
        dropdownPage.selectFromDropdown(option2);
        var selectedOptions = dropdownPage.getSelectedOptions();
        assertEquals(selectedOptions.size(), 2,
                "Incorrect number of selections");
        assertTrue(selectedOptions.contains(option1), "Option1 was not selected");
        assertTrue(selectedOptions.contains(option2), "Option2 was not selected");
    }

}
