package com.testcases;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
public class FirstCloudTest {
	
	public static RemoteWebDriver driver;
	
	public static final String username ="ninalagerstrom_9hcEUm";
	public static final String key ="pV8C1t2MqPNstLY3DLZP";
	
	public static String url = "https://"+username+ ":" +key+ "@hub-cloud.browserstack.com/wd/hub";
	
	
	@Test
	
	public void MobileCloudTest() throws InterruptedException, MalformedURLException
	{
		
		System.out.println(url);
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("os_version", "16");
		capabilities.setCapability("deviceName", "iPhone 14");
		capabilities.setCapability("browser", "safari");
		
		capabilities.setCapability("name", "Google Test");
		
		driver = new RemoteWebDriver(new URL(url),capabilities);
		
		driver.get("https://www.google.com/");
		
		//To enter any search term in the text box
		
		Thread.sleep(5000);
		
		
		driver.findElement(By.xpath("//textarea[@name='q12212']")).sendKeys("SimiliLearn");
		
		Thread.sleep(5000);
		
		driver.quit();
	}
}







