package demos;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestngDemo {

	@BeforeClass
	public void beforeClass() {
		System.out.println("@BeforeClass");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("@BeforeMethod");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("@BeforeTest");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("@AfterMethod");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("@AfterTest");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("@AfterClass");
	}
	
	
	@Test(description="description of testngTest1")
	public void testngTest1() {
		System.out.println("testngTest1");
		assertEquals(1, 2);
	}
	
	// runs after testngTest1 but only if passes
	@Test(dependsOnMethods={"testngTest1"})
	public void testngTest2() {
		System.out.println("testngTest2");
	}
	
	// always runs after testngTest1 (regardless if passes)
	@Test(dependsOnMethods={"testngTest1"}, alwaysRun=true)
	public void testngTest3() {
		System.out.println("testngTest3");
	}
	
	@Test(enabled=false)
	public void testngTest4() {
		System.out.println("testngTest4");
	}
	
	@Test(timeOut=500) // in ms
	public void testngTest5() throws InterruptedException {
		Thread.sleep(1000);
	}

	@Test(groups={"priority1"})
	public void testngTest6() {
		System.out.println("testngTest6 - priority1 group");
	}
	
	@Test(groups={"priority2"})
	public void testngTest7() {
		System.out.println("testngTest7 - priority2 group");
	}
	
	
	@Parameters({"first-name"})
	@Test
	public void paramFromXml(String firstName) {
		System.out.println(firstName);
	}
	
	// from http://testng.org/doc/documentation-main.html
	@DataProvider(name = "test1")
	public Object[][] createData1() {
		return new Object[][] {
			{ "Cedric", new Integer(36) },
			{ "Anne", new Integer(37) },
		};
	}
	
	@Test(dataProvider = "test1")
	public void verifyData1(String n1, Integer n2) {
		System.out.println(n1 + " " + n2);
	}

}
