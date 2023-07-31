package testScripts;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;

//import base.TestBase;

public class TC1_Verify_Excel_Data extends TestBase{
	
	@BeforeTest
	public void launchBrowser() {
		testSetUp(getClass().getName());
		//initialization();
	}
	
	@Test
	public void executeTest() {
		String datafromExcel=dataTable.getData("General_Data", "Column2");
		String TESTdATAfromExcel=dataTable.getData("Test_Data", "Column2");
		System.out.println(datafromExcel);
		System.out.println(TESTdATAfromExcel);
	}
	
	/*
	 * @AfterTest public void quitDriver() { tearDown(); }
	 */
	
	

}
