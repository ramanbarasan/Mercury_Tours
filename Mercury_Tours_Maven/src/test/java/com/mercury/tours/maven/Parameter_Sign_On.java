package com.mercury.tours.maven;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Parameter_Sign_On {
	public ChromeDriver driver;	
	
	@Test
	@Parameters({"url","uname","upass"})
	public void Sign_On_Successful_Login(String url, String username, String password) throws InterruptedException 
	{
		driver.navigate().to(url);
		driver.findElementByLinkText("SIGN-ON").click();
		driver.findElement(By.name("userName")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("login")).click();
		Thread.sleep(3000);
	}
	
	@BeforeTest
	public void Launch_Browser()
	{
		String absolutepath = System.getProperty("user.dir");
		String filepath = absolutepath+"\\Drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",filepath);		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@AfterTest
	public void Close_Browser()
	{
		driver.quit();
	}

}
