package com.mercury.tours.maven;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class Drag_Drop {
public ChromeDriver driver;
	
	@Test
	public void Sign_On_Successful_Login() throws InterruptedException 
	{
		Actions action = new Actions(driver);
		WebElement drag = driver.findElement(By.id("draggable"));		
		WebElement drop = driver.findElement(By.id("droppable"));
		action.dragAndDrop(drag, drop).build().perform();
		Thread.sleep(5000);
	}
	
	@BeforeTest
	public void Launch_Browser()
	{
		String absolutepath = System.getProperty("user.dir");
		String filepath = absolutepath+"\\Drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",filepath);		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
	}

	@AfterTest
	public void Close_Browser()
	{
		driver.quit();
	}

}
