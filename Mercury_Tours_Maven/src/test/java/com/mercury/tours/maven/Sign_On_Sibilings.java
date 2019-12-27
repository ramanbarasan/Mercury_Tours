package com.mercury.tours.maven;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Sign_On_Sibilings {
public ChromeDriver driver;
	
	@Test
	public void Sign_On_Successful_Login() throws InterruptedException 
	{
		driver.findElementByLinkText("SIGN-ON").click();
		driver.findElement(By.name("userName")).sendKeys("testing");
		driver.findElement(By.name("password")).sendKeys("testing");
		driver.findElement(By.name("login")).click();
		Thread.sleep(6000);
		
		String Actualurl = "http://newtours.demoaut.com/mercuryreservation.php";
		String Expecturl = driver.getCurrentUrl();
		System.out.println(Actualurl);
		Assert.assertEquals(Actualurl, Expecturl);
		
		String actualtitle = "Find a Flight: Mercury Tours:";
		String Expecttitle = driver.getTitle();
		System.out.println(actualtitle);
		Assert.assertEquals(actualtitle, Expecttitle);
		
		driver.findElement(By.xpath("//td[@width='73']//following-sibling::td[1]/a")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//td[@width='78']/preceding-sibling::td[1]/a")).click();
		
	}
	
	@BeforeTest
	public void Launch_Browser()
	{
		String absolutepath = System.getProperty("user.dir");
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
