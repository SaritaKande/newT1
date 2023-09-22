package TestLayer;



import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BaseLayer.BaseClass;
import PageLayer.RegisterPage;
import UtilsLayer.ExcelReader;
import static UtilsLayer.UtilsClass.*;


public class RegisterPageTest extends BaseClass {

	public static String userName1;
	public static String passWord;

	@Parameters({ "browserName" })
	@BeforeTest
	public void seUp(String browserName) {
		initialization(browserName);
	}

	@DataProvider
	public Object[][] addUserData() {
		ExcelReader exr = new ExcelReader(
				System.getProperty("user.dir") + "\\src\\main\\java\\TestDataLayer\\guru991.xlsx");
		Object data[][] = exr.getSheetData(0);
		return data;
	}
	
	@Test(dataProvider = "addUserData")
	public void validateRegisterPageFunctionality(String FirstName, String LastName, String Phone, String Email,String Address, String City, String State, String PCode,String Country,String UserName, String Password, String ConfirmPassword)
			throws Exception {
		RegisterPage regPage = new RegisterPage();
		regPage.contactInformationFunctionality(FirstName, LastName, Phone, Email);
		regPage.mailingInformationFunctionality(Address, City, State, PCode, Country);
		String userName1 = UserName;
		String passWord =  Password;
		regPage.userInformayionFunctionality(UserName, Password, ConfirmPassword);
		
	}

	
	

}
