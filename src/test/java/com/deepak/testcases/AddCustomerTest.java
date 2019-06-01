package com.deepak.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.deepak.base.TestBase;
import com.deepak.utilities.TestUtil;

public class AddCustomerTest extends TestBase{
	@Test(dataProviderClass = TestUtil.class,dataProvider="dp")
	public void addCustomerTest(String firstname,String lastname,String postcode,String alertText) throws InterruptedException {
		
		click("addCustBtn_CSS");
		type("firstname_CSS", firstname);
		type("lastname_XPATH",lastname);
		type("postcode_CSS", postcode);
		click("addBtn_CSS");
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		
		Assert.assertTrue(alert.getText().contains(alertText));
		alert.accept();
		Assert.fail();

	}
}
