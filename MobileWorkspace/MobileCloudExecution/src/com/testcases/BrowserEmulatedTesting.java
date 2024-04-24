package com.testcases;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
public class BrowserEmulatedTesting {
	
	public static WebDriver driver;
	
	
	@Test
	
	public void StartTest() throws IOException
	{
		WebDriverManager.chromedriver().setup();
		
		String deviceName = "Pixel 7";
		
		ChromeOptions options = new ChromeOptions();
		
		//To set the mobile emulation we have to set the exp option
		
		options.setExperimentalOption("mobileEmulation", Map.of("deviceName",deviceName));
		
		driver = new ChromeDriver(options);
		
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
			File destFile = new File("./Screenshots/screenshot_Emulated.png");
			
			FileUtils.copyFile(srcFile, destFile);
			
		}
		else
		{
			System.out.println("Incorrect landing page");
		}
		
		driver.quit();
		
	}
}




if(driver.getCurrentUrl().contains("Shirts"))
		{
			System.out.println("The user is in Shirts Landing page");
			File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File destFile = new File("./Screenshots/emulated.png");
			
			FileUtils.copyFile(srcFile, destFile);
			
		}
		else
		{
			System.out.println("Incorrect landing page");
		}
