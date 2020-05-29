package alerts;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FileUploadTests extends BaseTests {

    @Test
    public void testFileUpload() {
        var uploadPage = homePage.clickFileUpload();
        uploadPage.uploadFile("/home/ben/bengit/java-selenium/tau/pom.xml");
        assertEquals(uploadPage.getUploadedFiles(), "pom.xml");
    }
}
