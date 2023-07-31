package utils;

import java.io.FileInputStream;

import org.apache.commons.compress.archivers.zip.X0015_CertificateIdForFile;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import base.TestBase;

public class ExcelReader{
	
	String currentClassName=null;
	
	public ExcelReader(String className) {
		this.currentClassName=className;
	}
	
	public String getData(String sheetName, String columnName) {
		String testData=null;
		System.out.println(currentClassName);
		try {
			
			String projectPath=System.getProperty("user.dir");
			String defaultPath=System.getProperty("user.dir") + "\\src\\test\\resources\\WebsiteData.xlsx";
			FileInputStream fis=new FileInputStream(defaultPath);
			XSSFWorkbook wBook=new XSSFWorkbook(fis);
			int sheets=wBook.getNumberOfSheets();
			wBook.getSheet(sheetName);
			for(int i =0;i<sheets;i++) {
				if(wBook.getSheetName(i).equalsIgnoreCase(sheetName))
				{
					
				}
			}
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return testData;
	}

}
