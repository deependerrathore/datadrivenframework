package com.deepak.pages.twitter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.deepak.config.*;
public class twitEditProfile {
	WebDriver driver;
	
	public twitEditProfile(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(xpath = Configuration.changeYourProfileElem)
	public WebElement changeYourProfileElem;
	
	@FindBy(xpath=Configuration.uploadMenuDropDown)
	public WebElement uploadMenuDropDown;
	
	@FindBy(xpath= Configuration.cancelUploadPhotoBtn)
	public WebElement cancelUploadPhotoBtn;
	
	@FindBy(xpath=Configuration.cancelMenuDropDown)
	public WebElement cancelMenuDropDown;
	
	
	public void changeYourProfileIcon() throws InterruptedException {
		changeYourProfileElem.click();
		uploadMenuDropDown.sendKeys("C:\\Users\\deepak\\Desktop\\IMG_3913.JPG");
		cancelUploadPhotoBtn.click();
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(cancelMenuDropDown));
		cancelMenuDropDown.click();		
	}
}
