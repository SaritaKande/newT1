package TestLayer;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import BaseLayer.BaseClass;
import PageLayer.SignOnPage;


public class SignOnPageTest extends BaseClass{
	
	SignOnPage signOn;
	
	@Ignore
	@Test(priority = 1)
	public void closPopUp() {
		signOn= new SignOnPage();
		signOn.clickOnPopUp();
	}
	
	@Test(priority=2)
	public void validateSignOnPageUrl() {
		signOn = new SignOnPage();
		Assert.assertEquals(signOn.signOnUrl().startsWith("https://demo.guru"), true);
	}
	
	@Test(priority=3)
	public void validateSignOnPageTitle() {
		Assert.assertEquals(signOn.signOntitle().contains("Mercury"), true);
	}
	
	@Test(priority=4)
	public void validateSignOnPageFunctionality() {
		signOn.signOnPageFunctionality();
		
	}
	
	
	
	

}
