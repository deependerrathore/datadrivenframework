package com.deepak.utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import com.deepak.base.TestBase;

public class TestUtil extends TestBase {

	public static String screenshotPath;
	public static String screenshotName;

	public static void captureScreenshot() throws IOException {

		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Date d = new Date();
		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
		FileUtils.copyFile(srcFile,
				new File(System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\" + screenshotName));
	}

	@DataProvider(name="dp")
	public Object[][] getData(Method m) {

		String sheetName = m.getName();

		int rowsCount = excel.getRowCount(sheetName);
		int colsCount = excel.getColumnCount(sheetName);

		Object[][] data = new Object[rowsCount - 1][1];

		HashMap<String,String> table = null;
		for (int row = 2; row <= rowsCount; row++) {
			table = new HashMap<String, String>();
			for (int col = 0; col < colsCount; col++) {
				table.put(excel.getCellData(sheetName, col, 1), excel.getCellData(sheetName, col, row));
				data[row - 2][0] = table;
			}
		}

		return data;
	}
	
	public static boolean isTestRunnable(String testName,ExcelReader excel) {

		String sheetName = "test_suite";
		int rows = excel.getRowCount(sheetName);
		
		for (int row_number = 2; row_number <= rows; row_number++) {
			String testCase = excel.getCellData(sheetName, "TCID", row_number);

			if (testCase.equalsIgnoreCase(testName)) {

				String runMode = excel.getCellData(sheetName, "Runmode", row_number);
				
				
				if (runMode.equalsIgnoreCase("Y")) {
					//System.out.println("Test name passed from listener " + testName.toUpperCase() + " test case in TestUtil : " + testCase.toUpperCase() + " Runmode = " + runMode);
					return true;
				}
				else {
					return false;
				}
			}
		}
		return false;
	}
}
