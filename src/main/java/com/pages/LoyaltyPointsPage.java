package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import com.configure.Base;
import com.helper.CommonHelper;
import com.pages.objectRepository.BusinessManagerLocators;
import com.pages.objectRepository.LoyaltyPointsLocators;

public class LoyaltyPointsPage {
	
	WebDriver driver= Base.driver;
	private static Logger log = LoggerFactory.getLogger(AddToCartPage.class);
	private Double LoyaltyPointsBal = 0.00;
	private Double FetchedTotalAwardPoints = 0.00;
	private Double CalculatedTotalAwardPoints = 0.00;
	private int Calc = 0;
	
	public void LoyaltyPointsBalance() {
		LoyaltyPointsBal = CommonHelper.convertStringAmountToDouble(LoyaltyPointsLocators.LoyaltyPointsBalance);
		log.info("Loyalty Points Balance " +LoyaltyPointsBal);
	}
	
	public void CompareTotalLoyaltyAwardPoints(Double ProdPrice, Double Spend1, Double Award1, Double Rfactor) {
		FetchedTotalAwardPoints = CommonHelper.convertStringAmountToDouble(LoyaltyPointsLocators.TotalLoyaltyAwardPoints);
		log.info("Fetched Total Loyalty Award Points " +FetchedTotalAwardPoints);
		
		Calc = (int) (ProdPrice/Spend1);
		CalculatedTotalAwardPoints = Calc*Award1*Rfactor;
		log.info("Calculated Total Loyalty Award Points " +CalculatedTotalAwardPoints);
		
		Assert.assertEquals(FetchedTotalAwardPoints, CalculatedTotalAwardPoints);
		log.info("Total Loyalty Award Points on Checkout page matched");
	}
	
	public void SelectPaymentMethod() {
		//CommonHelper.clickElement(LoyaltyPointsLocators.LoyaltyPointsPaymentMode);
		log.info("Clicking Loyalty Points Payment Method");
		Base.driver.findElement(LoyaltyPointsLocators.LoyaltyPointsPaymentMode).click();
		log.info("Assert if Loyalty Points Payment Method selected ");
		Boolean PayLoyaltyPoints = Base.driver.findElement(LoyaltyPointsLocators.LoyaltyPointsPaymentMode).isSelected();
		Assert.assertTrue(PayLoyaltyPoints);
		log.info("Loyalty Points Payment Method selected");
	}
	
	public void OpenBusinessManager() {
		Base.driver.navigate().to("https://ukfy02.cloudfyprod.com/v3dev4/businessmanager");
		log.info("Business Manager signin page opened");
		Base.driver.findElement(BusinessManagerLocators.BMUsername).sendKeys("williams");
		log.info("Entered Username");
		Base.driver.findElement(BusinessManagerLocators.BMPassword).sendKeys("X1NMTFOXBQ63ysyy2lopBl+qd9tWRZOTk3Qgc6X9v8+d6UlOnis5DOV18DgYLSF3");
		log.info("Entered Password");
		CommonHelper.clickElement(BusinessManagerLocators.BMSignIn);
		log.info("Clicked on SignIn Button");
	}
	
	public void ClickBusinessManagerMenu(String Menu) {
		String BusinessManagerMenu = CommonHelper.dynamicXpath(BusinessManagerLocators.BMMenuDyxpath, Menu);
		CommonHelper.clickElement(By.xpath(BusinessManagerMenu));
		log.info("Clicked on Menu");
	}
	
	public void ClickBusinessManagerSubMenu(String SubMenu) {
		String BusinessManagerSubMenu = CommonHelper.dynamicXpath(BusinessManagerLocators.BMSubMenuDyxpath, SubMenu);
		CommonHelper.clickElement(By.xpath(BusinessManagerSubMenu));
		log.info("Clicked on SubMenu");
	}
	
	public void CheckOrderEntry() {
		CommonHelper.clickElement(BusinessManagerLocators.CheckFirstOrderEntry);
		Boolean Checked = Base.driver.findElement(BusinessManagerLocators.CheckFirstOrderEntry).isSelected();
		Assert.assertTrue(Checked);
		log.info("Checked First Order Entry");
	}
	
	public void SelectOrderStatus() {
		
	}
	
	

}
