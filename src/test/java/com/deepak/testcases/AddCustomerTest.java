package com.deepak.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.deepak.base.TestBase;

public class AddCustomerTest extends TestBase{
	@Test(dataProvider="getData")
	public void addCustomer(String firstname,String lastname,String postcode,String alertText) throws InterruptedException {
		
		driver.findElement(By.cssSelector(OR.getProperty("addCustBtn"))).click();
		driver.findElement(By.cssSelector(OR.getProperty("firstname"))).sendKeys(firstname);
		driver.findElement(By.cssSelector(OR.getProperty("lastname"))).sendKeys(lastname);
		driver.findElement(By.cssSelector(OR.getProperty("postcode"))).sendKeys(postcode);
		driver.findElement(By.cssSelector(OR.getProperty("addBtn"))).click();
		
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		
		Assert.assertTrue(alert.getText().contains(alertText));
		alert.accept();
		Assert.fail();

	}
	
	@DataProvider
	public Object[][] getData(){
		
		String sheetName = "AddCustomerTest";
		
		int rowsCount = excel.getRowCount(sheetName); 
		int colsCount = excel.getColumnCount(sheetName);
		
		Object[][] data = new Object[rowsCount-1][colsCount];
		
		for (int row = 2; row <= rowsCount; row++) {
			for (int col = 0; col < colsCount; col++) {
				data[row-2][col] = excel.getCellData(sheetName, col, row);
			}
		}
		
		return data;
	}
}
