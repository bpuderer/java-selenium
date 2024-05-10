package alerts;

import base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FileUploadTest extends BaseTest {

    @Test
    public void testFileUpload() {
        var uploadPage = homePage.clickFileUpload();
        uploadPage.uploadFile("/home/ben/bengit/java-selenium/tau/pom.xml");
        assertEquals(uploadPage.getUploadedFiles(), "pom.xml");
    }
}
