package com.mercury.tours.maven;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Links_Navigation {
public ChromeDriver driver;
	
	@Test
	public void Links_Navigation_Successful()
	{
		List<WebElement> linksize = driver.findElements(By.tagName("a"));
		int linkscount = linksize.size();
		System.out.println("Total no. of links Available:" + linkscount);
		String[] links = new String[linkscount];
		System.out.println("List of links Available");
		//print all the links from Webpage
		for (int i=0; i<linkscount; i++)
		{
			links[i] = linksize.get(i).getAttribute("href");
			System.out.println(linksize.get(i).getAttribute("href"));
		}
		
		//Navigate to each link on the Webpage
		for(int i=0; i<linkscount; i++)
		{
			driver.navigate().to(links[i]);
			System.out.println(driver.getTitle());
			driver.navigate().back();
		}
	}
	
	@BeforeTest
	public void Launch_Browser()
	{
		String absolutepath = System.getProperty("user.dir");
		String filepath = absolutepath+"\\Drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",filepath);		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.com/");
	}

	@AfterTest
	public void Close_Browser()
	{
		driver.quit();
	}

}
