package com.deepak.pages.twitter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class twitLandingPage {
	
	WebDriver driver;
	public twitLandingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(xpath="//div[@class='DashboardProfileCard-name u-textTruncate']//a[@href='/deepen_rathore']")
	public WebElement profile;
	
	@FindBy(xpath="//li/a/span[text()='Tweets']")
	public WebElement tweets;
	
	@FindBy(xpath="//li/a/span[text()='Following']")
	public WebElement following;
	
	@FindBy(xpath="//li/a/span[text()='Followers']")
	public WebElement followers;
	
	public twitProfilePage gotoProfile() {
		profile.click();
		return PageFactory.initElements(driver, twitProfilePage.class);
	}
	
	public void gotoTweets() {
		tweets.click();
	}
	
	public void gotoFollowing() {
		following.click();
	}
	
	public void gotoFollowers() {
		followers.click();
	}
}
