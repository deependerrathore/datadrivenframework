package com.deepak.testcases;

import java.util.HashMap;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.deepak.base.TestBase;
import com.deepak.utilities.TestUtil;

public class AddCustomerTest extends TestBase{
	@Test(dataProviderClass = TestUtil.class,dataProvider="dp")
	public void addCustomerTest(HashMap<String, String> data) throws InterruptedException {
		
		if (data.get("runmode").equalsIgnoreCase("N")) {
			throw new SkipException("Skipping the test case as the runmode of the data is NO");
		}
		click("addCustBtn_CSS");
		type("firstname_CSS", data.get("firstname"));
		type("lastname_XPATH",data.get("lastname"));
		type("postcode_CSS", data.get("postcode"));
		click("addBtn_CSS");
		
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		Assert.assertTrue(alert.getText().contains(data.get("alerttext")));
		alert.accept();
		Thread.sleep(2000);

	}
}
