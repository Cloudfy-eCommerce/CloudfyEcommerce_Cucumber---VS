package com.pages.objectRepository;

import org.openqa.selenium.By;

public class SignInPageLocators {
	
	//V3dev
	/*public static By AcceptCookies = By.xpath("//span[text()='I Accept']/parent::button");
	public static By SIGNIN = By.xpath("//a[text()='Login ']");
	//public static By SIGNIN = By.xpath("//a[text()=' SIGN IN']");
	
	public static By USERNAME = By.xpath("//input[@id='UserName']");
	public static By PASSWORD = By.xpath("//input[@id='Password']");
	public static By LoginToYourAccount = By.xpath("//button[text()='login to your account']");
	public static By MyAccount = By.xpath("//div[@class='myAccountDescription']/child::h1[text()='My Account']");
	public static By InvalidUserNamePasswordError = By.xpath("//span[text()='The user name or password provided is incorrect.']");
	*/
	//V3dev4
	public static By AcceptCookies = By.xpath("//span[text()='I Accept']/parent::button");
	public static By SIGNIN = By.xpath("(//a[@class='loginLinkRet'])[2]");
	public static By USERNAME = By.xpath("//input[@id='UserName']");
	public static By PASSWORD = By.xpath("//input[@id='Password']");
	public static By LoginToYourAccount = By.xpath("//button[text()='login to your account']");
	public static By MyAccount = By.xpath("//div[@class='myAccountDescription']/child::h1/button[text()='My Account']");
	public static By InvalidUserNamePasswordError = By.xpath("//span[text()='The user name or password provided is incorrect.']");
	
}
