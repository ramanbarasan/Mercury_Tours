package com.mercury.tours.maven;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.*;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Robot_Uploadfile {
public ChromeDriver driver;
String absolutepath = System.getProperty("user.dir");
	
	@Test
	public void TestUpload() throws InterruptedException 
	{
		String filepath = absolutepath+"\\UploadFiles\\Login.jpg";
		System.out.println(filepath);
		driver.findElement(By.id("btnChooseFiles")).click();
		uploadfile(filepath);
		Thread.sleep(1000);
	}
	
	public void uploadfile(String filelocation)
	{
		//upload file through ROBOT API
		StringSelection ss = new StringSelection(filelocation);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		//native key strokes for CTRL, V and Enter Keys
		Robot robot;
		try 
		{
			robot = new Robot();
			robot.delay(1000);
			
			//Press CTRL+V
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			
			//Release CTRL+V
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);
			
			//Press Enter
			robot.delay(1000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.delay(1000);			
		} 
		catch (AWTException e) 
		{
			e.printStackTrace();
		}		
		
	}
	
	@BeforeTest
	public void Launch_Browser()
	{
		String filepath = absolutepath+"\\Drivers\\IEDriverServer.exe";
		System.setProperty("webdriver.chrome.driver",filepath);		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://gofile.io/?t=uploadFiles");
	}

	@AfterTest
	public void Close_Browser()
	{
		driver.quit();
	}

}
