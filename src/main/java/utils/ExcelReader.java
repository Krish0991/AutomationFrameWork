package utils;

import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.commons.compress.archivers.zip.X0015_CertificateIdForFile;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
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
					XSSFSheet sheet=wBook.getSheetAt(i);
					Iterator<Row> rows=sheet.rowIterator();
					Row firstRow=rows.next();
					Iterator<Cell> ce=firstRow.cellIterator();
					int k=0;
					int column=0;
					int l=0;
					int desiredColumn=0;
					while(ce.hasNext()) {
						Cell value=ce.next();
						if(value.getStringCellValue().equalsIgnoreCase("TC1_Verify_Excel_Data")) {
							column=k;
						}
						k++;
						if(value.getStringCellValue().equalsIgnoreCase(columnName)) {
							desiredColumn=l;
						}
						l++;
					}
					while(rows.hasNext()) {
						Row r = rows.next();
						if(r.getCell(column).getStringCellValue().equalsIgnoreCase("TC1_Verify_Excel_Data"))
						{
							testData=r.getCell(desiredColumn).getStringCellValue();
							System.out.println(testData);
						}
					}
				}
			}
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return testData;
	}

}
