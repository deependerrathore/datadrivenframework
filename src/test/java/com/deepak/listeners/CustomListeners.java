package com.deepak.listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;

import com.deepak.base.TestBase;
import com.deepak.utilities.TestUtil;
import com.relevantcodes.extentreports.LogStatus;

public class CustomListeners extends TestBase implements ITestListener {
	
	public void onTestStart(ITestResult result) {
		test = rep.startTest(result.getName().toUpperCase());
		//runmodes
		if (!TestUtil.isTestRunnable(result.getName(), excel)) {
			throw new SkipException("Skipping the test case " + result.getName().toUpperCase() +"  as run mode of the test case is N");
		}
	}

	public void onTestSuccess(ITestResult result) {
		test.log(LogStatus.PASS, result.getName().toUpperCase() +" is passed");		
		rep.endTest(test);
		rep.flush();
	}

	public void onTestFailure(ITestResult result) {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		try {
			TestUtil.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test.log(LogStatus.FAIL, result.getName().toUpperCase() +" is failed with exception: " + result.getThrowable());		
		test.log(LogStatus.FAIL,test.addScreenCapture(TestUtil.screenshotName));
		
		Reporter.log("Test Case failed" + result.getName());
		Reporter.log("Click to see the screenshot");
		Reporter.log("<a target=\"_blank\" href="+TestUtil.screenshotName+">Screenshot<a/>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\" href="+TestUtil.screenshotName+"><img src="+TestUtil.screenshotName+" width=200 height=200/><a/>");		
		
		
		rep.endTest(test);
		rep.flush();
	}

	public void onTestSkipped(ITestResult result) {
		test.log(LogStatus.SKIP, result.getName().toUpperCase() +" is skipped as the run mode of the test case is N");		
		rep.endTest(test);
		rep.flush();
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	
}
