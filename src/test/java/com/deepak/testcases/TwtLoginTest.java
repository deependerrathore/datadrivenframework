package com.deepak.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.deepak.base.TestBase;
import com.deepak.pages.twitter.twitEditProfile;
import com.deepak.pages.twitter.twitLandingPage;
import com.deepak.pages.twitter.twitLoginPage;
import com.deepak.pages.twitter.twitProfilePage;
import com.relevantcodes.extentreports.LogStatus;

public class TwtLoginTest extends TestBase{

	@Test
	public void twtLoginTest() throws InterruptedException {
		test.log(LogStatus.INFO, "Inside twitter login test");
		twitLoginPage lp = PageFactory.initElements(driver, twitLoginPage.class);
		twitLandingPage landingPage =  lp.doLogin("deepak.republic@gmail.com", "taylor.shift");
		
		Thread.sleep(5000);
		
		test.log(LogStatus.INFO, "Login successfully done");
		twitProfilePage profile = landingPage.gotoProfile();
		test.log(LogStatus.INFO, "user is on profile page");

		Thread.sleep(3000);
		
		twitEditProfile editProfile = profile.editProfile();
		test.log(LogStatus.INFO, "user is on edit profile page");
		
		
		editProfile.changeYourProfileIcon();
		
		Thread.sleep(2000);
		
		
		
		
	}
}
