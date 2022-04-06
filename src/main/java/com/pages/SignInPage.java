package com.pages;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import com.configure.Base;
import com.helper.CommonHelper;
import com.helper.JSHelper;
import com.pages.SignInPage;
import com.pages.objectRepository.SignInPageLocators;

public class SignInPage {
	
	WebDriver driver= Base.driver;
    private static Logger log = LoggerFactory.getLogger(SignInPage.class);
    public SignInPage(){
    
    }
    
    public static void AcceptCookies() {
	
		try {
			JSHelper.click(Base.driver.findElement(SignInPageLocators.AcceptCookies));
			log.info("Accepted Cookies");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
    
	public static void clickSignInLink() {
		CommonHelper.clickElement(SignInPageLocators.SIGNIN);
		log.info("Clicked on Signin/login");
	}
	    
	public static void clickSignInButton() {
		CommonHelper.clickElement(SignInPageLocators.LoginToYourAccount);
		log.info("Clicked on Login To Your Account button");
	}    
    
	public static void enterUserName(String UName) {
		CommonHelper.sendKeystoElement(SignInPageLocators.USERNAME, UName);
	}
	
	public static void enterPwd(String Pwd) {
		CommonHelper.sendKeystoElement(SignInPageLocators.PASSWORD, Pwd);
	}
	
	public static void MyAccount() {
		Boolean isdisplayed = CommonHelper.isElementDisplayed(SignInPageLocators.MyAccount);
		Assert.assertTrue(isdisplayed);
	}
	
	public static void NotMyAccount() {
		JSHelper.scrollPageBy();
		Boolean isdisplayed = CommonHelper.isElementDisplayed(SignInPageLocators.InvalidUserNamePasswordError);
		Assert.assertTrue(isdisplayed);
	}
	
}
