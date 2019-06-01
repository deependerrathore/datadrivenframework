package com.deepak.testcases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.deepak.base.TestBase;


public class BankManagerLoginTest extends TestBase {
	
	@Test
	public void bankManagerLoginTest() throws IOException, InterruptedException {
		verifyEquals("abc", "xyz");
		Thread.sleep(3000);
		log.debug("Inside Login Test");
		click("bmlBtn_CSS");
		assertTrue(isElementPresent(By.cssSelector(OR.getProperty("addCustBtn_CSS"))), "Failed to login");
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
