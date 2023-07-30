package testScripts;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;

//import base.TestBase;

public class TC1_Verify_Excel_Data extends TestBase{
	
	@BeforeTest
	public void launchBrowser() {
		testPrerequisite(getClass().getName());
		//initialization();
	}
	
	@Test
	public void executeTest() {
		//dataTable.getData(null, null);
	}
	
	/*
	 * @AfterTest public void quitDriver() { tearDown(); }
	 */
	
	

}
