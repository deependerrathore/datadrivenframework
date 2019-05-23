package com.deepak.testcases;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.deepak.base.TestBase;

public class BankManagerLoginTest extends TestBase {
	
	@Test
	public void loginToBankManager() {
		log.debug("Inside Login Test");
		driver.findElement(By.cssSelector(OR.getProperty("bmlBtn"))).click();
		assertTrue(isElementPresent(By.cssSelector(OR.getProperty("addCustBtn"))), "Failed to login");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.debug("Login successfully loaded");

	}
}
