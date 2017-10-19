package demos;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
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
	
	@Test
	public void testngTest1() {
		System.out.println("testngTest1");
	}
	
	@Test
	public void testngTest2() {
		System.out.println("testngTest2");
	}
}
