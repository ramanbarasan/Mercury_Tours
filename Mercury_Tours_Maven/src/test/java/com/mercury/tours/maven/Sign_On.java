package com.mercury.tours.maven;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Sign_On {
public ChromeDriver driver;
	
	@Test
	public void Sign_On_Successful_Login() throws InterruptedException 
	{
		driver.findElementByLinkText("SIGN-ON").click();
		driver.findElement(By.name("userName")).sendKeys("testing");
		driver.findElement(By.name("password")).sendKeys("testing");
		driver.findElement(By.name("login")).click();
		Thread.sleep(6000);
		
		WebElement element_signoff = driver.findElement(By.linkText("SIGN-OFF"));
		String Actualtxt = element_signoff.getText();
		String Expecttxt = "SIGN-OFF";
		System.out.println(Actualtxt);
		Assert.assertEquals(Actualtxt, Expecttxt);
		
		String Actualurl = "http://newtours.demoaut.com/mercuryreservation.php";
		String Expecturl = driver.getCurrentUrl();
		System.out.println(Actualurl);
		Assert.assertEquals(Actualurl, Expecturl);
		
		String actualtitle = "Find a Flight: Mercury Tours:";
		String Expecttitle = driver.getTitle();
		System.out.println(actualtitle);
		Assert.assertEquals(actualtitle, Expecttitle);
		
		String radio_roundtrip = driver.findElement(By.xpath("//input[@value='roundtrip']")).getAttribute("checked");
		if(radio_roundtrip.equalsIgnoreCase("true"))
		{
			System.out.println("RoundTrip is selected");
		}
		
		WebElement element_radio_oneway = driver.findElement(By.xpath("//input[@value='oneway']"));
		element_radio_oneway.click();
		System.out.println("Clicked one way radio button");
		Assert.assertEquals(element_radio_oneway.isSelected(), true);
		Thread.sleep(2000);
		
		WebElement element_radio_business = driver.findElement(By.cssSelector("input[value='Business']"));
		element_radio_business.click();
		System.out.println("Clicked Business radio button");
		Assert.assertEquals(element_radio_business.isSelected(), true);
		Thread.sleep(2000);
		
		element_signoff.click();
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
