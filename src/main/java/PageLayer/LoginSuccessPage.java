package PageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseLayer.BaseClass;

public class LoginSuccessPage extends BaseClass{
	
	@FindBy (xpath="//h3[text()='Login Successfully']")
	private WebElement loginSuccessPhysicalText;
	
	public LoginSuccessPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public String captureSuccessMessage() {
		return loginSuccessPhysicalText.getText();
	}

}
