package com.mercury.tours.maven;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Read_Excel_XLS{
	private static Sheet ExcelWSheet;
	private static Workbook ExcelWBook;
	
	public String[][] getExcelData(String url, String fileName, String sheetName) throws EncryptedDocumentException, IOException
	{
		String[][] arrayExcelData = null;
		FileInputStream ExcelFile = new FileInputStream(fileName);
		
		ExcelWBook = WorkbookFactory.create(ExcelFile);
		ExcelWSheet = ExcelWBook.getSheet(sheetName);
		
		int totalNoOfRows = ExcelWSheet.getLastRowNum();
		int totalNoOfCols_0 = ExcelWSheet.getRow(0).getLastCellNum();		
		arrayExcelData = new String [totalNoOfRows][totalNoOfCols_0];
		
		for(int i=0; i<totalNoOfRows; i++)
		{
			int totalNoOfCols = ExcelWSheet.getRow(i).getLastCellNum();
			for(int j=0; j<totalNoOfCols; j++)
			{
				arrayExcelData[i][j] = ExcelWSheet.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		System.out.println(arrayExcelData);
		return arrayExcelData;
	}

}
