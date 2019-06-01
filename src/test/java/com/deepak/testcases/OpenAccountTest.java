package com.deepak.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.deepak.base.TestBase;
import com.deepak.utilities.TestUtil;

public class OpenAccountTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void openAccountTest(String customer, String currency) throws InterruptedException {
		
		click("openaccount_CSS");
		select("customer_CSS", customer);

		select("currency_CSS", currency);

		click("process_CSS");

		Alert alert = wait.until(ExpectedConditions.alertIsPresent());		
		alert.accept();

	}
}
