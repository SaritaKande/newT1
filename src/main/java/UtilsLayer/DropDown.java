package UtilsLayer;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import BaseLayer.BaseClass;

public class DropDown extends BaseClass{
	
	public static void selectByVisibleText(WebElement wb, String value) {
		new Select(wb).selectByVisibleText(value);
	}
	
	public static void selectByIndex(WebElement wb, int index)
	{
		new Select(wb).selectByIndex(index);
	}
	
	public static void selectByValue(WebElement wb, String value)
	{
		new Select(wb).selectByValue(value);
	}
	
	public static void getFirstSelectedOption(WebElement wb) {
		new Select(wb).getFirstSelectedOption();
	}
	
	public static void getAllOptions(WebElement wb) {
		List<WebElement> ls = new Select(wb).getOptions();
		for(WebElement a : ls) {
			a.getText();
		}
	}

}
