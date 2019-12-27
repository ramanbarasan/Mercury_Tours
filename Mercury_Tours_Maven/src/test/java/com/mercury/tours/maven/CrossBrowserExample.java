package com.mercury.tours.maven;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;

public class CrossBrowserExample {
	public WebDriver driver;
	
	@Test
	@Parameters({"url","uname","upass"})
	public void Sign_On_Successful_Login(String url, String username, String password) throws InterruptedException 
	{
		driver.navigate().to(url);
		driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElement(By.name("userName")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("login")).click();
		Thread.sleep(3000);
	}
	
	@BeforeTest
	@Parameters("browser")
	public void Launch_Browser(String browser) throws Exception
	{
		if (browser.equalsIgnoreCase("Chrome"))
		{
			String absolutepath = System.getProperty("user.dir");
			String filepath = absolutepath+"\\Drivers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver",filepath);		
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		else
		{
			String absolutepath = System.getProperty("user.dir");
			String filepath = absolutepath+"\\Drivers\\IEDriverServer.exe";
			System.setProperty("webdriver.ie.driver",filepath);		
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
		}
	}

	@AfterTest
	public void Close_Browser()
	{
		driver.quit();
	}


}
