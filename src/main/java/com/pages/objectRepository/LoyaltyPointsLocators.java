package com.pages.objectRepository;

import org.openqa.selenium.By;

public class LoyaltyPointsLocators {
	
	public static By LoyaltyPointsBalance = By.xpath("//*[contains(text(),'Loyalty Points Balance')]/following-sibling::span");
	public static By TotalLoyaltyAwardPoints = By.xpath("//tr[@class='award-points']/td/following-sibling::td");
	public static By LoyaltyPointsPaymentMode = By.xpath("//input[@id='rdbLoyaltyPoints']");
	
}
