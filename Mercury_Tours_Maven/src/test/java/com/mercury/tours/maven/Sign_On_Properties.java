package com.mercury.tours.maven;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Sign_On_Properties {
public ChromeDriver driver;
File file = new File("C:\\Selenium Training\\selenium-workspace\\Mercury_Tours_Maven\\Mercury_Tools.properties");
Properties prop = new Properties();
	
	@Test
	public void Sign_On_Successful_Login() throws InterruptedException, IOException 
	{
		FileInputStream fileinput = new FileInputStream(file);
		prop.load(fileinput);
		driver.findElement(By.linkText(prop.getProperty("lsignon"))).click();
		driver.findElement(By.name(prop.getProperty("Iusername"))).sendKeys("testing");
		driver.findElement(By.name(prop.getProperty("Iuserpass"))).sendKeys("testing");
		driver.findElement(By.name(prop.getProperty("Clogin"))).click();
		Thread.sleep(2000);		
	}
	
	@BeforeTest
	public void Launch_Browser() throws IOException
	{
		String absolutepath = System.getProperty("user.dir");
		String filepath = absolutepath+"\\Drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",filepath);		
		driver = new ChromeDriver();	
		FileInputStream fileinput = new FileInputStream(file);
		prop.load(fileinput);
		driver.get(prop.getProperty("URL"));
		driver.manage().window().maximize();
	}

	@AfterTest
	public void Close_Browser()
	{
		driver.quit();
	}

}
