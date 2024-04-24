package com.testcases;

import java.io.IOException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
public class CalculatorLaunchApp {
	
	public static AndroidDriver driver;
	
	public static final String username ="harishafcutest1";
	public static final String key ="WRzL8XCDjyEcE6cPvTbz";
	
	public static String url = "https://"+username+ ":" +key+ "@hub-cloud.browserstack.com/wd/hub";
	
	@Test
	
	public void MobileCloudTest() throws InterruptedException, IOException
	{
		System.out.println(url);
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("os_version", "9.0");
		capabilities.setCapability("device", "Google Pixel 3");
		
		capabilities.setCapability("app", "bs://04e5b10b8b87cc2a8370375ab43a1842b6ce8a9e");
		
		
		//To launch a default application inside a device
		
	//	capabilities.setCapability("appPackage", "com.android.calculator2");
	//	capabilities.setCapability("appActivitiy", "com.android.calculator2.Calculator");
		
		capabilities.setCapability("name", "API Demos App Test");
		
		driver = new AndroidDriver(new URL(url),capabilities);
		
		Thread.sleep(5000);
		
	}
}


