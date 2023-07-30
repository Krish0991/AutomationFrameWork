package pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class HomePage extends TestBase{
	
	

	private final String txtBoxInput="//input[@id='my-text-id']";
	
	private final String selectDrpDown="//select[@name='my-select']";
	
	private final String fileUpload="//input[@type='file']";
	
	private final String colorPicker="//input[@name='my-colors']";
	
	public String getWebSiteName() {
		return driver.getTitle();
	}
	
	public void enterTextBox() {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(txtBoxInput)));
		driver.findElement(By.xpath(txtBoxInput)).sendKeys("jfff");;
	}
	
	public void selectAppDropdown() {
		Wait<WebDriver> wait=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(40)).pollingEvery(Duration.ofSeconds(10)).ignoring(Exception.class);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(selectDrpDown)));
		Select drpDown=new Select(driver.findElement(By.xpath(selectDrpDown)));
		 drpDown.selectByVisibleText("One");
	}
	
	public void uploadFile() {
		WebElement uploadFile=driver.findElement(By.xpath(fileUpload));
		uploadFile.sendKeys("C:\\Users\\USER\\Desktop\\Data-types-in-Java.jpg");
	}
	
	public void colorPicker() {
		driver.findElement(By.xpath(colorPicker)).sendKeys("#2A2A2D");
	}

}
