package com.qa.opencart.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {

	private static Workbook book;
	private static Sheet sheet;
	
	public static Object[][] getTestData(String sheetName) 
	{
		Object[][] data=null;		
		try {
			FileInputStream ip = new FileInputStream(Constants.TEST_DATA_SHEET_PATH); //Connect to xlsx file with FileInput stream 
			book=WorkbookFactory.create(ip);										// Create same file structure(Workbook) in Java memory
			sheet=book.getSheet(sheetName);											//create sheet 
			
			
			 data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()]; //no of rows n no of columns
			 for(int i=0; i<sheet.getLastRowNum();i++) 
			 {
				 for(int j=0;j<sheet.getRow(0).getLastCellNum();j++)
				 {
					 data[i][j]=sheet.getRow(i+1).getCell(j).toString();
				 }
				 
			 }
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return data;
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
