package PageLayer;

import static UtilsLayer.UtilsClass.click;
import static UtilsLayer.UtilsClass.getTitle;
import static UtilsLayer.UtilsClass.getUrl;
import static UtilsLayer.UtilsClass.sendKeys;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseLayer.BaseClass;

public class SignOnPage extends BaseClass{
	
	@FindBy(xpath = "//span[text()='Close']")
	private WebElement closepop;

	@FindBy(name = "userName")
	private WebElement username;

	@FindBy(name = "password")
	private WebElement password;

	@FindBy(name = "submit")
	private WebElement submit;

	public SignOnPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public void clickOnPopUp() {
		click(closepop);
	}

	public String signOnUrl() {
		return getUrl();
	}

	public String signOntitle() {
		return getTitle();
	}

	public void signOnPageFunctionality() {
		sendKeys(username, RegisterPage.UserName);
		sendKeys(password, RegisterPage.PassWord);
		click(submit);
	}


}
