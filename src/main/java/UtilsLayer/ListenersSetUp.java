package UtilsLayer;

import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ListenersSetUp implements ITestListener {

	ExtentReports extentReports;
	ExtentTest extentTest;

	public void onStart(ITestContext context) {
		extentReports = ExtentReportSetUp.setUp("Suit is started" + context.getSuite().getName());

	}

	public void onTestStart(ITestResult result) {
		extentTest = extentReports.createTest("Test is started" + result.getMethod().getMethodName());

	}

	public void onTestSuccess(ITestResult result) {
		extentTest.log(Status.PASS, "Test case is Passed" + result.getMethod().getMethodName());
		try {
			extentTest.addScreenCaptureFromPath(
					ExtentReportSetUp.takesScreenshot("PassScreenshot", result.getMethod().getMethodName()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestFailure(ITestResult result) {
		extentTest.log(Status.FAIL, "Test case is fail" + result.getMethod().getMethodName());
		try {
			extentTest.addScreenCaptureFromPath(
					ExtentReportSetUp.takesScreenshot("FailScreenshot", result.getMethod().getMethodName()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		extentTest.log(Status.SKIP, "Test case is skipped" + result.getMethod().getMethodName());
	}

	public void onFinish(ITestContext context) {
		extentReports.flush();
	}

}
