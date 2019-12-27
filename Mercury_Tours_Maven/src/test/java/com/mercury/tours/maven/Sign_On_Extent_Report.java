package com.mercury.tours.maven;

import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class Sign_On_Extent_Report {
public ChromeDriver driver;
ExtentHtmlReporter htmlReporter;
ExtentReports extent;
ExtentTest test;
	
	@Test(priority=2)
	public void Sign_On_Successful_Login() throws InterruptedException 
	{
		test = extent.createTest("Test case 2", "Login to Mercury we application");
			
		driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElement(By.name("userName")).sendKeys("testing");
		driver.findElement(By.name("password")).sendKeys("testing");
		driver.findElement(By.name("logins")).click();
		Thread.sleep(2000);
	}	
	
	@Test(priority=1)
	public void Launch_Browser()
	{
		test = extent.createTest("Test case 1", "Launch Chrome browser and Navigate to chrome");
		
		String absolutepath = System.getProperty("user.dir");
		String filepath = absolutepath+"\\Drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",filepath);		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://newtours.demoaut.com/index.php");
	}
	
	@BeforeTest
	public void startReport()
	{
		//Initialize HTML reporter
		//htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/testReport.html");
		
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/testReport.html");
		//Initialize extent reports and attach the HTML reporter
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		//To add system or environment info by using the setSystemInfo method.
		extent.setSystemInfo("OS", "Windows 10");
		extent.setSystemInfo("Browser", "Chrome");
		
		//Configuration items to change the look and feel
		//add content, manage test etc
		//htmlReporter.config().setChartVisibilityOnOpen(true);
		//htmlReporter.config().setTestViewChartLocation(chartLocation.Top);
		htmlReporter.config().setDocumentTitle("Extent Report Demo");
		htmlReporter.config().setReportName("Test Report");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
	}	
	
	@AfterMethod
	public void getResult(ITestResult result)
	{
		if(result.getStatus() == ITestResult.FAILURE)
		{
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+"FAILED", ExtentColor.RED));
			test.fail(result.getThrowable());
		}
		else if(result.getStatus() == ITestResult.SUCCESS)
		{
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+"PASSED", ExtentColor.GREEN));
		}
		else
		{
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+"SKIPPED", ExtentColor.ORANGE));
			test.skip(result.getThrowable());
		}
	}
	
	@AfterTest
	public void Close_Browser()
	{
		driver.quit();
		extent.flush();
	}

}
