package com.deepak.testcases;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.deepak.base.TestBase;


public class BankManagerLoginTest extends TestBase {
	
	@Test
	public void bankManagerLoginTest() {
		log.debug("Inside Login Test");
		click("bmlBtn_CSS");
		assertTrue(isElementPresent(By.cssSelector(OR.getProperty("addCustBtn"))), "Failed to login");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.debug("Login successfully loaded");
		Assert.fail("Failing Login");
	}
}
