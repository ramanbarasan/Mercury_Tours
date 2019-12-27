package com.mercury.tours.maven;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;

public class Headless_Browser {
public ChromeDriver driver;
ChromeOptions options;
	
	@Test
	public void Sign_On_Successful_Login() 
	{
		driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElement(By.name("userName")).sendKeys("testing");
		driver.findElement(By.name("password")).sendKeys("testing");
		driver.findElement(By.name("login")).click();
	}
	
	@BeforeTest
	public void Launch_Browser()
	{
		options = new ChromeOptions();
		options.setHeadless(false);
		options.addArguments("incognito");
		String absolutepath = System.getProperty("user.dir");
		String filepath = absolutepath+"\\Drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",filepath);		
		driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.get("http://newtours.demoaut.com/index.php");
	}

	@AfterTest
	public void Close_Browser()
	{
		driver.quit();
	}

}
