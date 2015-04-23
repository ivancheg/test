package android.screens;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SignInScreen extends AbstractScreen{

	@AndroidFindBy(xpath = "(//*[@class='android.widget.Button'])[1]")
	public WebElement singInFbBtn;

	@AndroidFindBy(xpath = "(//*[@class='android.widget.Button'])[2]")
	public WebElement singInForsquareBtn;
	
	@AndroidFindBy(xpath = "(//*[@class='android.widget.Button'])[3]")
	public WebElement singUpEmailBtn;
	
	@AndroidFindBy(xpath = "(//*[@class='android.widget.Button'])[4]")
	public WebElement loginBtn;
	
	public SignInScreen(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
}
