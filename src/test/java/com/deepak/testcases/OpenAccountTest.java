package com.deepak.testcases;

import java.util.HashMap;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.deepak.base.TestBase;
import com.deepak.utilities.TestUtil;

public class OpenAccountTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void openAccountTest(HashMap<String, String> data) throws InterruptedException {
			
		Thread.sleep(3000);
		click("openaccount_CSS");
		select("customer_CSS", data.get("customer"));

		select("currency_CSS", data.get("currency"));

		click("process_CSS");
		
		Thread.sleep(2000);
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());		
		alert.accept();

	}
}
