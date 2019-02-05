package test;

import org.testng.annotations.Test;

import test.DragDropUI;
import utilities.Init;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class NewTest {

	@Test
	public void DragDropTest() {

		DragDropUI ddtest = new DragDropUI();
		ddtest.DragDropTest();
	}

	@BeforeClass
	public void beforeClass() {
		// Lauch URL
		Init.LaunchURL();

	}

	@AfterClass
	public void afterClass() {
		// nt required
	}

	@BeforeSuite
	public void beforeSuite() {
		// Initialize Driver
		Init.InitializeDriver();
	}

	@AfterSuite
	public void afterSuite() {
		// Driver Quit
		Init.Quit();
	}

}
