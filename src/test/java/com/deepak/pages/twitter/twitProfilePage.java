package com.deepak.pages.twitter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.deepak.config.Configuration;

public class twitProfilePage {
	
	WebDriver driver;
	
	public twitProfilePage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(xpath= Configuration.editButton)
	public WebElement editButton;
	
	public twitEditProfile editProfile() {
		editButton.click();
		
		return PageFactory.initElements(driver, twitEditProfile.class);
	}
}
