package com.mercury.tours.maven;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class HDFC_Netbanking {
public ChromeDriver driver;
	
	@Test
	public void Sign_On_Successful_Login() throws InterruptedException 
	{
		driver.switchTo().frame("login_page");		
		WebElement element_usertxt = driver.findElement(By.xpath("//input[@name='fldLoginUserId']"));
		element_usertxt.sendKeys("2309910");
		driver.findElement(By.cssSelector("img[alt='continue']")).click();
		driver.switchTo().defaultContent();		
		Thread.sleep(6000);
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
