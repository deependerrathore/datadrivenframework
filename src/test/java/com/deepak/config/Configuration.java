package com.deepak.config;

public class Configuration {

	// Login page
	public static final String username = "//*[@id=\"page-container\"]/div/div[1]/form/fieldset/div[1]/input";

	public static final String password = "//*[@id=\"page-container\"]/div/div[1]/form/fieldset/div[2]/input";

	public static final String signin = "//*[@id=\"page-container\"]/div/div[1]/form/div[2]/button";

	// Landing Page
	public static final String profile = "//div[@class='DashboardProfileCard-name u-textTruncate']//a[@href='/deepen_rathore']";

	public static final String tweets = "//li/a/span[text()='Tweets']";

	public static final String following = "//li/a/span[text()='Following']";

	public static final String followers = "//li/a/span[text()='Followers']";

	// Profile
	public static final String editButton = "//*[@id=\"page-container\"]/div[3]/div/div[2]/div[2]/div/div[2]/div/div/ul/li[8]/div/button";

	// Edit Profile Page
	public static final String changeYourProfileElem = "//*[@id=\"page-container\"]/div[3]/div/div[1]/div[4]/div[1]/div[2]/div[5]/button/div[2]";

	public static final String uploadMenuDropDown = "//*[@id=\"photo-choose-existing\"]/div/div/label/input";

	public static final String cancelUploadPhotoBtn ="//*[@id=\"profile_image_upload_dialog-dialog\"]/div[2]/div[3]/button[1]";

	public static final String cancelMenuDropDown = "//*[@id=\"choose-photo\"]/div/div/ul/li[5]/button";

}
