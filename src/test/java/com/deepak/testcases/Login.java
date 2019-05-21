package com.deepak.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.deepak.base.TestBase;

public class Login extends TestBase {
	@Test
	public void loginToBankManager() {
		driver.findElement(By.cssSelector(OR.getProperty("bmlBtn"))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
