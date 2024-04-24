package com.testcases;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
public class AppBasicInteractions {
	
	@Test
	
	public void BasicInteractions() throws MalformedURLException, InterruptedException
	{
		DesiredCapabilities caps = new DesiredCapabilities();
		
		//Access details for the cloud provider - Step 1 - Put the access details
		
		caps.setCapability("browserstack.user", "harishafcutest1");
		caps.setCapability("browserstack.key", "WRzL8XCDjyEcE6cPvTbz");
		
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
		
		//Click on the first option in the app
		
		driver.findElementByAccessibilityId("Accessibility").click();
Thread.sleep(3000);
Thread.sleep(5000);
//To navigate back to the app screens
driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
//To click on any element by using the text of the element in the screen
Thread.sleep(3000);
//To find the element with the help of text
driver.findElementByAndroidUIAutomator("text(\"App\")").click();
Thread.sleep(3000);
driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
//To find the element with the help of xpath
driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Accessibility\"]")).click();
Thread.sleep(3000);
//Navigate back to the main App screen
driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
//To navigate to the SMS messaging screen to input data
Thread.sleep(2000);
driver.findElementByAndroidUIAutomator("text(\"OS\")").click();
Thread.sleep(2000);
driver.findElementByAccessibilityId("SMS Messaging").click();
//We need create an Android Element
AndroidElement SmsMessage = driver.findElementById("io.appium.android.apis:id/sms_recipient");


SmsMessage.sendKeys("SONALI");
System.out.println(driver.isKeyboardShown());
/*driver.hideKeyboard();
System.out.println(driver.isKeyboardShown());*/




driver.pressKey(new KeyEvent(AndroidKey.SPACE));
Thread.sleep(4000);
driver.pressKey(new KeyEvent(AndroidKey.M));
Thread.sleep(4000);
driver.closeApp();
driver.quit();
	
		
		
	}
	
	
}

