package android.popups;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

import org.openqa.selenium.WebElement;

import android.screens.AbstractScreen;

public class ForgotPasswordPopup extends AbstractScreen{
	
	@AndroidFindBy(xpath = "(//*[@class='android.widget.EditText'])[1]")
	public WebElement fogotPassEmailInput;
	
	@AndroidFindBy(xpath = "(//*[@class='android.widget.TextView'])[4]")
	public WebElement ok;
	
	@AndroidFindBy(xpath = "(//*[@class='android.widget.TextView'])[3]")
	public WebElement cansel;
	
	public ForgotPasswordPopup(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
}
