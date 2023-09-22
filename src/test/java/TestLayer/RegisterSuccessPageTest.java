package TestLayer;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseLayer.BaseClass;
import PageLayer.RegisterSuccessPage;

public class RegisterSuccessPageTest extends BaseClass{
	
	RegisterSuccessPage rsPage;
	
	@Test(priority=1)
	public void validateHomePageUrl() {
		rsPage = new RegisterSuccessPage();
		Assert.assertEquals(rsPage.registerSuccessPageUrl().contains("guru99.com"), true);
	}
	
	
	
	@Test(priority=2)
	public void validateRegisterSuccessPageTitle() {
		
		Assert.assertEquals(rsPage.registerSuccessPageTitle().contains("Mercury Tours"),true);
	}
	
	@Test(priority=3)
	public void clickOnSubmit() {
		rsPage.clickSignIn();
	}

}
