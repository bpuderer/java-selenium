package demos;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

// right click on package and Run As > TestNG Test
public class TestngSuiteAnnotations {

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("@BeforeSuite");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("@AfterSuite");
	}
}
