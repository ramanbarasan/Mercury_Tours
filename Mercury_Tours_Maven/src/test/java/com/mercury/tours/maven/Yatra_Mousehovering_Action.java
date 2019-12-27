package com.mercury.tours.maven;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class Yatra_Mousehovering_Action {
public ChromeDriver driver;
	
	@Test
	public void Sign_On_Successful_Login() throws InterruptedException 
	{
		WebElement mousehover = driver.findElement(By.xpath("//a[contains(text(),'Support')]"));
		Actions action = new Actions(driver);
		action.moveToElement(mousehover).build().perform();
		driver.findElement(By.linkText("Contact Us")).click();
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
		driver.get("https://www.yatra.com/");
	}

	@AfterTest
	public void Close_Browser()
	{
		driver.quit();
	}

}
