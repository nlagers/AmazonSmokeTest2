package com.testcases;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
public class SeekBarHandling {
	
@Test
	
	public void SeekBarInteractions() throws MalformedURLException, InterruptedException
	{
		DesiredCapabilities caps = new DesiredCapabilities();
		
		//Access details for the cloud provider - Step 1 - Put the access details
		
		caps.setCapability("browserstack.user", "");
		caps.setCapability("browserstack.key", "");
		
		//Define the apk details = Step 2
		
		caps.setCapability("app", "bs://04e5b10b8b87cc2a8370375ab43a1842b6ce8a9e");
		
		//Define the device details - Step 3
		
		caps.setCapability("os_version", "9.0");
		caps.setCapability("device", "Google Pixel 3");
		
		//Step 4 - Build details
		
		caps.setCapability("project", "Appium Project");
		caps.setCapability("name", "Appium Test");
		
		//Initialise the driver to start the execution
		
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement> (new URL("https://hub.browserstack.com/wd/hub"),caps);
		
		Thread.sleep(5000);
		
		//To click on any element based on the index approach
		
		driver.findElementsById("android:id/text1").get(0).click();
		Thread.sleep(5000);
		//To navigate back to the app screens
		driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
		
		Thread.sleep(3000);
		
		//To click on any element based on the index approach
		
		driver.findElementsById("android:id/text1").get(10).click();
		Thread.sleep(5000);
		
		//To scroll to particular element (Seek Bar)
		
		MobileElement SeekBar = driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("
				+ "new UiSelector().description(\"Seek Bar\"));"));
		SeekBar.click();
		Thread.sleep(3000);
		
		AndroidElement SeekBarElement = driver.findElementById("io.appium.android.apis:id/seek");
		
		int StartXValue = SeekBarElement.getLocation().getX();
		int StartYValue = SeekBarElement.getLocation().getY();
		
		int EndXLocation = SeekBarElement.getSize().getWidth();
		
		System.out.println(StartXValue);
		System.out.println(StartYValue);
		System.out.println(EndXLocation);


		
		
		
	}
}

