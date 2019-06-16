package com.deepak.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.deepak.base.TestBase;
import com.deepak.pages.twitter.twtLoginPage;
import com.relevantcodes.extentreports.LogStatus;

public class TwtLoginTest extends TestBase{

	@Test
	public void twtLoginTest() throws InterruptedException {
		test.log(LogStatus.INFO, "Inside twitter login test");
		twtLoginPage lp = PageFactory.initElements(driver, twtLoginPage.class);
		lp.doLogin("deepak.republic@gmail.com", "XXXXX");
		
		Thread.sleep(5000);
	}
}
