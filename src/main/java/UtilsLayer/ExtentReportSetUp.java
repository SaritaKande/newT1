package UtilsLayer;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import BaseLayer.BaseClass;

public class ExtentReportSetUp extends BaseClass{
	
	public static ExtentReports extentReports;
	
	public static String date() {
		return new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
	}
	
	public static ExtentReports setUp(String reportName) {
		
		String path = System.getProperty("user.dir") + "\\ExtentReports\\" + reportName + date() + ".html";
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(path);
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);
		return extentReports;
	}
	
	public static String takesScreenshot(String folderName, String screenshotName) throws IOException {
		
		File f = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "\\" + folderName + "\\" + screenshotName + date() +".png";
		FileUtils.copyFile(f,new File(path));
		return path;
	}
	
	

}
