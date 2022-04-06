package com.pages;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import com.configure.Base;
import com.helper.CommonHelper;
import com.pages.objectRepository.BusinessManagerLocators;
import com.pages.objectRepository.VATLocators;

public class VATPage {
	
	private static Logger log = LoggerFactory.getLogger(VATPage.class);
	private Double CalculatedVATamount = 0.00;
    private Double SubTotalAmount = 0.00;
    private Double FetchedVATinCheckout = 0.00;
    private Double FetchedDiscountAmount = 0.00;
	
	public void CompareBillingCountry(String Country) {

		String BillingCountry = CommonHelper.getSelectedOption(VATLocators.BillingCountry);
		log.info("Billing Country " +BillingCountry);
		
		//Compare Billing Country
	}
	
	public void VATPriceforProduct(Double Percentage) {
		SubTotalAmount = CommonHelper.convertStringAmountToDouble(VATLocators.SubTotal);
		log.info("Sub Total Amount " +SubTotalAmount);
		/* if (no. of Products>1)
		 {
		 VAT Amount of Prod A = (Cost of Prod A * Vat % of Prod A)/100;
		 VAT Amount of Prod B = (Cost of Prod B * Vat % of Prod B)/100;
		 Total VAT Amount = VAT Amount of Prod A + VAT Amount of Prod B;
		 }
		*/
		//VATamount = (SubTotalAmount*Percentage)/100;
		FetchedVATinCheckout = CommonHelper.convertStringAmountToDouble(VATLocators.VatInCheckout);
		log.info("VAT Amount on Checkout page " +FetchedVATinCheckout);
		
		try {
			//Boolean isdisplayed = CommonHelper.isElementDisplayed(VATLocators.DiscountInCheckout);
			//Assert.assertTrue(isdisplayed);
			CommonHelper.isElementDisplayed(VATLocators.DiscountInCheckout);
			FetchedDiscountAmount = CommonHelper.convertStringAmountToDouble(VATLocators.DiscountInCheckout);
			log.info("Fetched Discount Amount " +FetchedDiscountAmount);
			
			CalculatedVATamount = (SubTotalAmount-FetchedDiscountAmount)*(Percentage/100);
			log.info("Calculated VAT Amount with Discount" +CalculatedVATamount);
		}
		catch (Exception e) {
			log.info(e.getMessage());
			CalculatedVATamount = (SubTotalAmount)*(Percentage/100);
			log.info("Calculated VAT Amount without Discount" +CalculatedVATamount);
		}
		
		Assert.assertEquals(FetchedVATinCheckout, CalculatedVATamount);
		log.info("VAT on Checkout page matched");	
	}
	
	public void ClickSiteSettingTab(String SiteSettingTab) {
		String BMSiteSettingTab = CommonHelper.dynamicXpath(BusinessManagerLocators.BMSiteSettingTabDyxpath, SiteSettingTab);
		CommonHelper.clickElement(By.xpath(BMSiteSettingTab));
		log.info("Clicked on Site Setting Tab");
	}
	
	public void ClickTransactionalSettingSection(String TransactionalSettingSection) {
		String BMTransactionalSettingSection = CommonHelper.dynamicXpath(BusinessManagerLocators.BMTransactionalSettingSectionDyxpath, TransactionalSettingSection);
		
		CommonHelper.clickElement(By.xpath(BMTransactionalSettingSection));
		log.info("Clicked on Transactional Setting Section");
	}
	
	public void SelectCalculateVATFromOption(String CalculateVATFrom) {
		
		CommonHelper.clickElement(BusinessManagerLocators.CalculateVATFromElement);
		log.info("Click Calculate VAT From Option Dropdown");
        CommonHelper.sendKeystoElement(BusinessManagerLocators.SearchDD, CalculateVATFrom);
        
        String SelectDDOption = CommonHelper.dynamicXpath(BusinessManagerLocators.DDOptionDyxpath, CalculateVATFrom);
		
		CommonHelper.clickElement(By.xpath(SelectDDOption));
        
		String SelectedText = Base.driver.findElement(BusinessManagerLocators.CalculateVATFromElement).getText();
		Assert.assertEquals(SelectedText,CalculateVATFrom);
		log.info("Selected Calculate VAT From Option " + CalculateVATFrom);
	}
	
	public void SelectVATMethodTypeOption(String VATMethodType) {
		
		CommonHelper.clickElement(BusinessManagerLocators.VATMethodTypeElement);
		log.info("Click Calculate VAT From Option Dropdown");
        CommonHelper.sendKeystoElement(BusinessManagerLocators.SearchDD, VATMethodType);
        
        String SelectDDOption = CommonHelper.dynamicXpath(BusinessManagerLocators.DDOptionDyxpath, VATMethodType);
        CommonHelper.clickElement(By.xpath(SelectDDOption));
        
		String SelectedText = Base.driver.findElement(BusinessManagerLocators.VATMethodTypeElement).getText();
		Assert.assertEquals(SelectedText,VATMethodType);
		log.info("Selected VAT Method Type Option " + VATMethodType);
	}
	
	public void SelectDeliveryTypeOption(String DeliveryType) {
		CommonHelper.clickElement(BusinessManagerLocators.DeliveryTypeElement);
		log.info("Click Calculate VAT From Option Dropdown");
        CommonHelper.sendKeystoElement(BusinessManagerLocators.SearchDD, DeliveryType);
        
        String SelectDDOption = CommonHelper.dynamicXpath(BusinessManagerLocators.DDOptionDyxpath, DeliveryType);
        CommonHelper.clickElement(By.xpath(SelectDDOption));
        
		String SelectedText = Base.driver.findElement(BusinessManagerLocators.DeliveryTypeElement).getText();
		Assert.assertEquals(SelectedText,DeliveryType);
		log.info("Selected Delivery Charges Option " + DeliveryType);
	}
	
	public void ClickSubmitButton() {
		CommonHelper.clickElement(BusinessManagerLocators.SubmitButton);
		log.info("Clicked on Submit Button");
	}

}
