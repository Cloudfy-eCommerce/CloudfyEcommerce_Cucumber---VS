package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import com.configure.Base;
import com.helper.CommonHelper;
import com.pages.objectRepository.AddToCartPageLocators;
import com.pages.objectRepository.BusinessManagerLocators;

public class DeliveryChargesPage {
	
	private static Logger log = LoggerFactory.getLogger(DeliveryChargesPage.class);
	//private Double FetchedDeliveryCharge =0.00;
	
	public void DeliveryChargeOfDeliveryTypeDisplayed(Double Charge, String DeliveryType) {
		
		CommonHelper.clickElement(AddToCartPageLocators.ShowDetailedDelivery);
		log.info("Show Detailed Delivery");
	
	String DelType = CommonHelper.dynamicXpath(AddToCartPageLocators.ExtendedDeliveryChoiceDyxpath, DeliveryType);
	//CommonHelper.clickElement(By.xpath(DelType));
	log.info(DelType);
	//FetchedDeliveryCharge = CommonHelper.convertStringAmountToDouble(By.xpath(DelType));
	WebElement Ele = Base.driver.findElement(By.xpath(DelType));
	String str = Ele.getText();
	log.info("Fetched amount as string " +str);
	String numberOnly= str.replaceAll("[^0-9.]", "");
	log.info("Fetched amount as string only numbers " +numberOnly);
	
	Double amt= Double.parseDouble(numberOnly);
	log.info("Fetched Amount " +amt);
	
	//log.info("Fetched Delivery Charge " +FetchedDeliveryCharge);
	
	Assert.assertEquals(amt, Charge);
	log.info("Delivery Amount on Checkout page matched");
}
	
public void DeliveryChargeOfDeliveryMethodforProductCountDisplayed(Double Charge, Double ProductCount, String DeliveryMethod) {
		CommonHelper.clickElement(AddToCartPageLocators.ShowDetailedDelivery);
		log.info("Show Detailed Delivery");
	
	String DelMethod = CommonHelper.dynamicXpath(AddToCartPageLocators.ExtendedDeliveryChoiceDyxpath, DeliveryMethod);
	log.info(DelMethod);
	WebElement Ele = Base.driver.findElement(By.xpath(DelMethod));
	String str = Ele.getText();
	log.info("Fetched amount as string " +str);
	String numberOnly= str.replaceAll("[^0-9.]", "");
	log.info("Fetched amount as string only numbers " +numberOnly);
	
	Double amt= Double.parseDouble(numberOnly);
	log.info("Fetched Amount " +amt);
	
	Double CalcCharge = (Charge*ProductCount);
	Assert.assertEquals(amt, CalcCharge);
	log.info("Delivery Amount on Checkout page matched");
}

public void SelectDeliveryMethod(String DeliveryMethod) {
	String selectDeliveryMethod = CommonHelper.dynamicXpath(AddToCartPageLocators.ChoiceExtendedDeliveryRadioButtonDyxpath, DeliveryMethod);
	//CommonHelper.clickElement(By.xpath(selectDeliveryType));
	Base.driver.findElement(By.xpath(selectDeliveryMethod)).click();
	log.info("Delivery Type Choice selected " +DeliveryMethod);
	
	CommonHelper.clickElement(AddToCartPageLocators.ShowDetailedDelivery);
	log.info("Show Detailed Delivery");
}

public void SelectDeliveryBreakdownLevel(String DeliveryBreakdownLevel) {
	CommonHelper.clickElement(BusinessManagerLocators.DeliveryBreakdownLevelElement);
	log.info("Click Delivery Breakdown Level Dropdown");
    CommonHelper.sendKeystoElement(BusinessManagerLocators.SearchDD, DeliveryBreakdownLevel);
    
    String SelectDDOption = CommonHelper.dynamicXpath(BusinessManagerLocators.DDOptionDyxpath, DeliveryBreakdownLevel);
    CommonHelper.clickElement(By.xpath(SelectDDOption));
    
	String SelectedText = Base.driver.findElement(BusinessManagerLocators.DeliveryBreakdownLevelElement).getText();
	Assert.assertEquals(SelectedText,DeliveryBreakdownLevel);
	log.info("Selected Delivery Breakdown Level " + DeliveryBreakdownLevel);
}


}
