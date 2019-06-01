package com.deepak.testcases;

import org.testng.annotations.Test;

import com.deepak.base.TestBase;
import com.deepak.utilities.TestUtil;

public class OpenAccountTest extends TestBase{
	
	@Test(dataProviderClass = TestUtil.class, dataProvider="dp")
	public void addCustomer(String customer,String currency) throws InterruptedException {
		
	}
}
