package com.deepak.pages.twitter;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class twtLoginPage {
	@FindBy(xpath="//*[@id=\"page-container\"]/div/div[1]/form/fieldset/div[1]/input")
	public WebElement username;
	
	@FindBy(how = How.XPATH , using = "//*[@id=\"page-container\"]/div/div[1]/form/fieldset/div[2]/input")
	public WebElement password;
	
	@FindBy(xpath="//*[@id=\"page-container\"]/div/div[1]/form/div[2]/button")
	public WebElement signin;
	
	//Business Login
	public void doLogin(String myusername,String mypassword) {
		username.sendKeys(myusername);
		password.sendKeys(mypassword);
		
		signin.click();
	}
}
