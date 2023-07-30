package testScripts;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import pages.CommonPage;
import pages.HomePage;

public class Selenium2ndScript extends TestBase{
	@BeforeTest
	public void launchBrowser() {
		initialization();
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


