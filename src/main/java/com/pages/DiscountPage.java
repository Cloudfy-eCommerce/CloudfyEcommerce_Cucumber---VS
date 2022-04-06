package com.pages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import com.helper.CommonHelper;
import com.pages.objectRepository.VATLocators;
import com.pages.objectRepository.DiscountLocators;


public class DiscountPage {
	
	private static Logger log = LoggerFactory.getLogger(DiscountPage.class);
	private Double FetchedDiscountinCheckout = 0.00;
	private Double SubTotalAmount = 0.00;
	
	public void EnterVoucherCode(String VoucherCode) {
		CommonHelper.sendKeystoElement(DiscountLocators.VoucherCode, VoucherCode);
		log.info("Voucher Code entered");
		CommonHelper.clickElement(DiscountLocators.ApplyVoucherCode);
		log.info("Voucher Code applied");
	}
	
	public void CalculateDiscount(Double DiscountPercentage) {
		SubTotalAmount = CommonHelper.convertStringAmountToDouble(VATLocators.SubTotal);
		log.info("Sub Total Amount " +SubTotalAmount);
		
		FetchedDiscountinCheckout = CommonHelper.convertStringAmountToDouble(DiscountLocators.DiscountInCheckout);
		log.info("Discount Amount on Checkout page " +FetchedDiscountinCheckout);
		
		Double CalculatedDiscountAmount = SubTotalAmount*(DiscountPercentage/100);
		log.info("Calculated Discount Amount" +CalculatedDiscountAmount);
		
		Assert.assertEquals(FetchedDiscountinCheckout, CalculatedDiscountAmount);
		log.info("Discount Amount on Checkout page matched");
	}
	
	public void CalculateDiscountAmt(Double DiscountAmount) {
		SubTotalAmount = CommonHelper.convertStringAmountToDouble(VATLocators.SubTotal);
		log.info("Sub Total Amount " +SubTotalAmount);
		
		FetchedDiscountinCheckout = CommonHelper.convertStringAmountToDouble(DiscountLocators.DiscountInCheckout);
		log.info("Discount Amount on Checkout page " +FetchedDiscountinCheckout);
		
		/*Double CalculatedDiscountAmount = SubTotalAmount*(DiscountAmount/100);
		log.info("Calculated Discount Amount" +CalculatedDiscountAmount);
		*/
		Assert.assertEquals(FetchedDiscountinCheckout, DiscountAmount);
		log.info("Discount Amount on Checkout page matched");
	}
	
	public void EnterValidVoucherCodeMessage() {
		Boolean isdisplayed = CommonHelper.isElementDisplayed(DiscountLocators.InvalidVoucherCodeMessage);
		Assert.assertTrue(isdisplayed);
		log.info("Please Enter Valid Voucher Code message displayed");
	}

}
