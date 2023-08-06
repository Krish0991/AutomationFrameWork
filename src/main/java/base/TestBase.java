package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ExcelReader;

public class TestBase {

	protected static WebDriver driver;
	protected ExcelReader dataTable;

	public Properties prop;
	protected String currentClassName = null;

	public TestBase() {
		prop = new Properties();
		try {
			FileInputStream fis = null;
			fis = new FileInputStream(
					"C:\\Users\\USER\\Desktop\\SeleniumScriptWorkspace\\SeleniumPOC\\src\\test\\resources\\LocalSetting.properties");
			prop.load(fis);
		} catch (IOException ex) {

		}
	}

	public void tearDown() {
		driver.quit();
	}

	public void testSetUp(String className) {
		String[] exactClassName=className.split("[.]");
		String testCaseName=exactClassName[exactClassName.length-1];
		dataTable = new ExcelReader(exactClassName);
		
		  currentClassName = className;
		  if(prop.getProperty("browser").equals("chrome")) {
		  WebDriverManager.chromedriver().setup(); driver=new ChromeDriver(); } else
		  if(prop.getProperty("browser").equals("edge")) {
		  WebDriverManager.edgedriver().setup(); driver=new EdgeDriver(); }
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		  driver.manage().window().maximize(); String urlValue=prop.getProperty("url");
		  driver.get(urlValue);
		 
	}

}
