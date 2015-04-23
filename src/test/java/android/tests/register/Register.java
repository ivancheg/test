package android.tests.register;

import com.google.api.services.gmail.model.Message;
import core.GmailAPIUtils;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import phones.PhoneUtil;
import android.popups.ForgotPasswordPopup;
import android.screens.LoginScreen;
import android.screens.SignInScreen;
import android.screens.SignUpWithEmail;

import com.google.api.services.gmail.Gmail;

import core.GenerateRandom;


public class Register {
	Gmail service;
	private AndroidDriver  driver;
	private static final String     url    = "http://127.0.0.1:4723/wd/hub";
	WebDriverWait wait; 
	private static final String CLIENT_SECRET_PATH = "src/test/resources/client_secret_1061853989813-a9g31qb48jl41pdaj8rbgddv11gniprd.apps.googleusercontent.com.json";	
	private static final String CLIENT_MAIL = "tuttest1107@gmail.com";
	private static final String CLIENT_PASS = "esdzp1107";
	private static final String APP_NAME = "atf";
	String email;


	@Test
	@Parameters({"deviceName"})
	public void regTest(String deviceName) throws Exception {
		driver = PhoneUtil.createAndroidDriver(deviceName, url);
		//		driver.startActivity("appPackage","com.mteam.mfamily", null, null);
		email = CLIENT_MAIL.split("@")[0]+"+"+GenerateRandom.randInt(100, 1000)+"@gmail.com";
		System.out.println(email);
		wait = new WebDriverWait(driver, 60);
		SignInScreen ss = new SignInScreen(driver);
		wait.until(ExpectedConditions.elementToBeClickable(ss.loginBtn));
		//@AndroidFindBy(className = "android.widget.Button")
		//		List<WebElement> androidButtons = driver.findElementsByClassName("android.widget.Button");
		//		System.out.println(androidButtons.size());
		//		driver.findElementsByClassName("android.widget.Button").get(1).click();
		//ss.loginBtn.click();
		//LoginScreen ls  = new LoginScreen (driver);
		//System.out.println(driver.currentActivity());
		//ls.login("cxhchj", "kvckvlc");
		//driver.hideKeyboard();
		//ls.forgotPasswordLink.click();
		//System.out.println(driver.currentActivity());
		//ForgotPasswordPopup fppoup = new  ForgotPasswordPopup(driver);
		//wait.until(ExpectedConditions.elementToBeClickable(fppoup.ok));
//		fppoup.fogotPassEmailInput.clear();
//		fppoup.fogotPassEmailInput.sendKeys("new mail");
//		System.out.println(fppoup.ok.getText());
//		System.out.println(fppoup.cansel.getText());
//		fppoup.ok.click();
//		fppoup.cansel.click();
//		ls.back.click();
		ss.singUpEmailBtn.click();
		SignUpWithEmail suwe = new SignUpWithEmail(driver);
		wait.until(ExpectedConditions.elementToBeClickable(suwe.signupBtn));
		suwe.nameInput.sendKeys("TestUser"+GenerateRandom.randInt(1000, 10000));
		suwe.emailInput.sendKeys(email);
		driver.hideKeyboard();
//		suwe.photo.click();
//		driver.navigate().back();
//		driver.navigate().back();
//		System.out.println(driver.currentActivity());
        suwe.signupBtn.click();
        Message mail = GmailChek.getGoogleEmail(email, service);
				System.out.println("mail");
				String confirmLink = GmailChek.getConfirmLinkFromMail(mail);
				System.out.println(confirmLink);
				String confirmCode = confirmLink.split("=")[2];
				System.out.println(confirmCode);
		//		suwe.takeScreenShot("play2");



		Thread.sleep(5000);

	}


	@BeforeTest
	public Gmail setUp() throws Exception {

				WebDriver fireFox = new FirefoxDriver();
				service = GmailAPIUtils.autorizeGmail(fireFox, CLIENT_MAIL, CLIENT_PASS, CLIENT_SECRET_PATH, APP_NAME);

		return service;

	}

	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();
	}

	
}
