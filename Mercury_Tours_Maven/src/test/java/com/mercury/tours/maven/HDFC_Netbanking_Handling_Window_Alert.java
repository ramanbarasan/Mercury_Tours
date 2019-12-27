package com.mercury.tours.maven;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class HDFC_Netbanking_Handling_Window_Alert {
public ChromeDriver driver;
	
	@Test
	public void Sign_On_Successful_Login() throws InterruptedException 
	{
		driver.switchTo().frame("login_page");		
		driver.findElement(By.cssSelector("img[alt='continue']")).click();
		String ActTest = driver.switchTo().alert().getText();
		String ExpTest = "Customer ID  cannot be left blank.";
		System.out.println(ActTest);
		Assert.assertEquals(ActTest, ExpTest);	
		driver.switchTo().alert().accept();
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
		driver.get("https://netbanking.hdfcbank.com/netbanking/");
	}

	@AfterTest
	public void Close_Browser()
	{
		driver.quit();
	}

}
