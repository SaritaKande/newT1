package TestLayer;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseLayer.BaseClass;
import PageLayer.LoginSuccessPage;

public class LoginSuccessPageTest extends BaseClass{
	
	@Test
	public void validateLoginSuccessPage() {
		LoginSuccessPage loginsuccess = new LoginSuccessPage();
		Assert.assertEquals(loginsuccess.captureSuccessMessage(),"Login Successfully");
	}

}
