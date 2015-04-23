package android.screens;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MyFamilyScreen extends AbstractScreen {
	
	@AndroidFindBy(xpath= "//*[@text='Invite new member']")
	public WebElement inviteBtn;
	
	@AndroidFindBy(xpath= "//*[@text='Join Family with Family ID']")
	public WebElement joinFamilyBtn;


    @AndroidFindBy(xpath = "(//*[@class='android.widget.ImageView'])[2]")
    public WebElement updateFamilyButton;

    @AndroidFindBy(xpath = "(//*[@class='android.widget.ImageView'])[1]")
    public WebElement menuButton;
	
	public MyFamilyScreen(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

}
