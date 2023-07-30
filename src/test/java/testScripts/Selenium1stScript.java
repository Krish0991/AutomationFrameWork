package testScripts;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base.TestBase;
import pages.CommonPage;
import pages.HomePage;

public class Selenium1stScript extends TestBase{
	
	
	@BeforeTest
	public void launchBrowser() {
		testSetUp(getClass().getName());
	}


	@Test
	public void executeTest() throws InterruptedException {
		
		HomePage hPage=new HomePage();
		hPage.enterTextBox();
		String actualTitle=hPage.getWebSiteName();
		AssertJUnit.assertEquals(actualTitle, "Web form");
		hPage.selectAppDropdown();
		hPage.colorPicker();
	}
	
	@AfterTest
	public void quitDriver() {
		tearDown();
	}

}
