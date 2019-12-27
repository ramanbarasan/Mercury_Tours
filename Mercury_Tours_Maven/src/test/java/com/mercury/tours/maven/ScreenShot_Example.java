package com.mercury.tours.maven;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class ScreenShot_Example {
public ChromeDriver driver;
String absolutepath = System.getProperty("user.dir");
String screenshot_spath = absolutepath+"\\Screenshots_Success";
String screenshot_fpath = absolutepath+"\\Screenshots_Failure";
	
	@Test
	public void Sign_On_Successful_Login() throws InterruptedException 
	{
		driver.findElementByLinkText("SIGN-ON").click();
		driver.findElement(By.name("userName")).sendKeys("testing");
		driver.findElement(By.name("password")).sendKeys("testing");
		driver.findElement(By.name("login")).click();
		Thread.sleep(3000);		
	}
	
	@AfterMethod
	public void teardown(ITestResult result)throws Exception
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
			File Browserscreenshots = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(Browserscreenshots, new File(screenshot_fpath +"/"+result.getName()+"_"+System.nanoTime()+".png"));
		}
		else if (ITestResult.SUCCESS==result.getStatus())
		{
			File Browserscreenshots1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(Browserscreenshots1, new File(screenshot_spath +"/"+result.getName()+"_"+System.nanoTime()+".png"));		
		}
	}
	
	@BeforeTest
	public void Launch_Browser()
	{
		String filepath = absolutepath+"\\Drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",filepath);		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://newtours.demoaut.com/index.php");
	}

	@AfterTest
	public void Close_Browser()
	{
		driver.quit();
	}

}
