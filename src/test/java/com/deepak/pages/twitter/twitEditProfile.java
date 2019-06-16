package com.deepak.pages.twitter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class twitEditProfile {
	WebDriver driver;
	
	public twitEditProfile(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(xpath="//*[@id=\"page-container\"]/div[3]/div/div[1]/div[4]/div[1]/div[2]/div[5]/button/div[2]")
	public WebElement changeYourProfileElem;
	
	//@FindBy(xpath="//*[@id=\"photo-choose-existing\"]/div/div/input[1]")
	@FindBy(xpath="//*[@id=\"photo-choose-existing\"]/div/div/label/input")
	public WebElement uploadMenuDropDown;
	
	@FindBy(xpath="//*[@id=\"profile_image_upload_dialog-dialog\"]/div[2]/div[3]/button[1]")
	public WebElement cancelUploadPhotoBtn;
	
	@FindBy(xpath="//*[@id=\"choose-photo\"]/div/div/ul/li[5]/button")
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
