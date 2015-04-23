package android.screens;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginScreen extends AbstractScreen{

	@AndroidFindBy(xpath = "(//*[@class='android.widget.EditText'])[1]")
	public WebElement emailInput;

	@AndroidFindBy(xpath = "(//*[@class='android.widget.EditText'])[2]")
	public WebElement passwordInput;

	@AndroidFindBy(xpath = "(//*[@class='android.widget.Button'])[1]")
	public WebElement loginBtn;
	
	@AndroidFindBy(xpath = "(//*[@class='android.widget.TextView'])[1]")
	public WebElement forgotPasswordLink;
	
	@AndroidFindBy(xpath = "(//*[@class='android.widget.ImageView'])[1]")
	public WebElement back;
	
	public void login(String email, String password){
		emailInput.sendKeys(email);
		passwordInput.sendKeys(password);
		loginBtn.click();
	}
	
	/****************Constructor**************/
	public LoginScreen(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

}
