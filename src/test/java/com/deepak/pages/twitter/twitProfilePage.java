package com.deepak.pages.twitter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class twitProfilePage {
	
	WebDriver driver;
	
	public twitProfilePage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(xpath="//*[@id=\"page-container\"]/div[3]/div/div[2]/div[2]/div/div[2]/div/div/ul/li[8]/div/button")
	public WebElement editButton;
	
	public twitEditProfile editProfile() {
		editButton.click();
		
		return PageFactory.initElements(driver, twitEditProfile.class);
	}
}
