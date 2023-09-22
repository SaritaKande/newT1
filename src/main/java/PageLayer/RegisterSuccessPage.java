package PageLayer;

import static UtilsLayer.UtilsClass.click;
import static UtilsLayer.UtilsClass.getTitle;
import static UtilsLayer.UtilsClass.getUrl;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseLayer.BaseClass;

public class RegisterSuccessPage extends BaseClass{
	
	@FindBy(xpath="//a[text()=' sign-in ']//preceding::img[6]")
	private WebElement logo;
	
	@FindBy(xpath="//a[text()=' sign-in ']")
	private WebElement signIn;
	
	
	
	public RegisterSuccessPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public String registerSuccessPageUrl() {
		return getUrl();
	}
	
	
	public String registerSuccessPageTitle() {
		return getTitle();
	}
	
	public void clickSignIn() {
		click(signIn);
	}


}
