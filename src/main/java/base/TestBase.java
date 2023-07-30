package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utils.ExcelReader;

public class TestBase {
	
	protected static WebDriver driver;
	protected ExcelReader dataTable=new ExcelReader();
	
	public Properties prop;
	String currentClassName=null;
	
	public TestBase() {
		prop=new Properties();
		try {
		FileInputStream fis=null;
		fis=new FileInputStream("C:\\Users\\USER\\Desktop\\SeleniumScriptWorkspace\\SeleniumPOC\\src\\test\\resources\\LocalSetting.properties");
		prop.load(fis);
		}
		catch(IOException ex) {
			
		}
	}
	
	public void tearDown() {
		driver.quit();
	}
	
	public void testSetUp(String className) {
		currentClassName=className;
		if(prop.getProperty("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\Desktop\\SeleniumScriptWorkspace\\SeleniumPOC\\src\\test\\resources\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(prop.getProperty("browser").equals("edge")) {
			
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().window().maximize();
		String urlValue=prop.getProperty("url");
		driver.get(urlValue);

		
	}
	
	
}
