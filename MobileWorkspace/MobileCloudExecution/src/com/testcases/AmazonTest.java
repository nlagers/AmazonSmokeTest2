package com.testcases;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;


public class AmazonTest {

public static RemoteWebDriver driver;
	
	public static final String username ="ninalagerstrom_9hcEUm";
	public static final String key ="pV8C1t2MqPNstLY3DLZP";
	
	public static String url = "https://"+username+ ":" +key+ "@hub-cloud.browserstack.com/wd/hub";
	
	
	@Test
	
	public void MobileCloudTest() throws InterruptedException, IOException
	{
		System.out.println(url);
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("os_version", "9.0");
		capabilities.setCapability("device", "Google Pixel 3");
		capabilities.setCapability("browser", "chrome");
		
		capabilities.setCapability("name", "Amazon Test");
		
		driver = new RemoteWebDriver(new URL(url),capabilities);
		
		driver.get("https://www.amazon.in/");
		
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		
		WebElement SearchBox = driver.findElement(By.xpath("//input[@name='k']"));
		SearchBox.sendKeys("Shirts");
		
		WebElement SearchIcon = driver.findElement(By.xpath("//input[@class='nav-input']"));
		SearchIcon.click();
		
		System.out.println(driver.getCurrentUrl());
		
		if(driver.getCurrentUrl().contains("shirts"))
		{
			System.out.println("The user is in Shirts Landing page");
			File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File destFile = new File("./Screenshots/screenshot.png");
			
			FileUtils.copyFile(srcFile, destFile);
			
		}
		else
		{
			System.out.println("Incorrect landing page");
		}
		
		driver.quit();
		
	}
}

