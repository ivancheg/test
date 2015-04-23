package phones;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class PhoneUtil {

	public static AndroidDriver createAndroidDriver(String deviceName, String appiumHubUrl) throws MalformedURLException{
		final DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("deviceName", Phones.valueOf(deviceName).getDeviceName());
		capabilities.setCapability("udid", Phones.valueOf(deviceName).getUdid());
		capabilities.setCapability("platformName", Phones.valueOf(deviceName).getPlatform());
		capabilities.setCapability(CapabilityType.VERSION, Phones.valueOf(deviceName).getAndroidVersion());
		capabilities.setCapability("newCommandTimeout", "0");
		capabilities.setCapability("appPackage", "com.mteam.mfamily");
		capabilities.setCapability("appActivity", ".ui.SplashScreenActivity");
		return new AndroidDriver(new URL(appiumHubUrl), capabilities);
		
	}

    public static IOSDriver createIOSDriver(String deviceName, String appiumHubUrl) throws MalformedURLException{
        final DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability("deviceName", Phones.valueOf(deviceName).getDeviceName());
        capabilities.setCapability("udid", Phones.valueOf(deviceName).getUdid());
        capabilities.setCapability("platformName", Phones.valueOf(deviceName).getPlatform());
        capabilities.setCapability(CapabilityType.VERSION, Phones.valueOf(deviceName).getAndroidVersion());
        capabilities.setCapability("newCommandTimeout", "0");
        //capabilities.setCapability("app", "/Users/admin/Downloads/mFamily_86_debug.ipa");
        capabilities.setCapability("bundleId", "mtech.mFamily");
        return new IOSDriver(new URL(appiumHubUrl), capabilities);
    }

    public static AndroidDriver createAndroidWebDriver(String deviceName, String appiumHubUrl) throws MalformedURLException{
        final DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "Browser");
        capabilities.setCapability("deviceName", Phones.valueOf(deviceName).getDeviceName());
        capabilities.setCapability("udid", Phones.valueOf(deviceName).getUdid());
        capabilities.setCapability("platformName", Phones.valueOf(deviceName).getPlatform());
        capabilities.setCapability(CapabilityType.VERSION, Phones.valueOf(deviceName).getAndroidVersion());
        capabilities.setCapability("newCommandTimeout", "0");
        //capabilities.setCapability("appPackage", "com.mteam.mfamily");
        //capabilities.setCapability("appActivity", ".ui.SplashScreenActivity");
        return new AndroidDriver(new URL(appiumHubUrl), capabilities);

    }
}
