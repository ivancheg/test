package android.screens;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SignUpWithEmail extends AbstractScreen{

	@AndroidFindBy(xpath = "(//*[@class='android.widget.ImageView'])[1]")
	public WebElement photo;
	
	@AndroidFindBy(xpath = "(//*[@class='android.widget.EditText'])[1]")
	public WebElement nameInput;

	@AndroidFindBy(xpath = "(//*[@class='android.widget.EditText'])[2]")
	public WebElement emailInput;

	@AndroidFindBy(xpath = "(//*[@class='android.widget.Button'])[1]")
	public WebElement signupBtn;
	
	@AndroidFindBy(xpath = "(//*[@class='android.widget.ImageView'])[3]")
	public WebElement back;
	
	
	
	public SignUpWithEmail(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	

}
