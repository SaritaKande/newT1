package PageLayer;

import static UtilsLayer.DropDown.selectByVisibleText;
import static UtilsLayer.UtilsClass.click;
import static UtilsLayer.UtilsClass.sendKeys;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseLayer.BaseClass;

public class RegisterPage extends BaseClass{
	
	static String UserName = null;
	static String PassWord = null;
	
	@FindBy(name = "firstName")
	private WebElement firstName1;

	@FindBy(name = "lastName")
	private WebElement lastName1;

	@FindBy(name = "phone")
	private WebElement phone1;

	@FindBy(name = "userName")
	private WebElement userName1;

	@FindBy(xpath = "//input[@name='address1']")
	private WebElement address1;

	@FindBy(xpath = "//input[@name='city']")
	private WebElement city1;

	@FindBy(xpath = "//input[@name='state']")
	private WebElement state1;

	@FindBy(xpath = "//input[@name='postalCode']")
	private WebElement postalcode1;

	@FindBy(xpath = "//select[@name='country']")
	private WebElement country1;

	@FindBy(name = "email")
	private WebElement email1;

	@FindBy(name = "password")
	private WebElement password1;

	@FindBy(name = "confirmPassword")
	private WebElement confirmPassword1;

	@FindBy(xpath = "//input[@name='submit']")
	private WebElement submit1;

	public RegisterPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public void contactInformationFunctionality(String fname, String lname, String phone2, String email2) {
		sendKeys(firstName1, fname);
		sendKeys(lastName1, lname);
		sendKeys(phone1, phone2);
		sendKeys(userName1, email2);
	}

	public void mailingInformationFunctionality(String add, String ciyy1, String state2, String pCode,
			String country2) {
		sendKeys(address1, add);
		sendKeys(city1, ciyy1);
		sendKeys(state1, state2);
		sendKeys(postalcode1, pCode);
		selectByVisibleText(country1, country2);
	}

	public void userInformayionFunctionality(String uName, String pass, String confirmPass) {
		UserName = uName;
		sendKeys(email1, uName);
		PassWord = pass;
		sendKeys(password1, pass);
		sendKeys(confirmPassword1, confirmPass);
		//pageRefresh();
		click(submit1);

	}


}
