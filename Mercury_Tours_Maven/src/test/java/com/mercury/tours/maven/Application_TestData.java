package com.mercury.tours.maven;

import java.io.IOException;
import org.testng.annotations.DataProvider;

public class Application_TestData 
{
	@DataProvider(name="Sign_On")
	
	public Object[][] getDataFromDataProvider()
	{
		return new Object[][]
		{
			{"http://newtours.demoaut.com/index.php","testing","testing"},
			{"http://newtours.demoaut.com/index.php","dixit","dixit"},
			{"http://newtours.demoaut.com/index.php","testabhi","testabhi"}
		};
	}
	
	@DataProvider(name="LoginDataXLS")	
	public Object[][] getExcelData() throws IOException
	{
		Read_Excel_XLSX excel = new Read_Excel_XLSX();
		Object[][] testObjArray = excel.getExcelData("url", "C:\\Selenium Training\\selenium-workspace\\Mercury_Tours_Maven\\Excel\\Mercury_Tours.xlsx", "Sheet1");
		System.out.println(testObjArray);		
		return testObjArray;		
	}

	
	@DataProvider(name="LoginDataXLS1")	
	public Object[][] getExcelData_XLS_XLSX() throws IOException
	{
		Read_Excel_XLS_XLSX excel1 = new Read_Excel_XLS_XLSX();
		Object[][] testObjArray1 = excel1.getExcelData_XLS_XLSX("url", "C:\\Selenium Training\\selenium-workspace\\Mercury_Tours_Maven\\Excel\\Mercury_Tours.xlsx", "Sheet1");
		System.out.println(testObjArray1);		
		return testObjArray1;		
	}

}
