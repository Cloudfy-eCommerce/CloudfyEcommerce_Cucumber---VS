package com.pages.objectRepository;

import org.openqa.selenium.By;

public class DiscountLocators {
	
	public static By VoucherCode = By.xpath("//input[@id='txtvouchercode']");
	public static By ApplyVoucherCode = By.xpath("//button[text()='Apply Code']");
	public static By DiscountInCheckout = By.xpath("//td[text()='Discount']/following-sibling::td");
	public static By InvalidVoucherCodeMessage = By.xpath("//span[@id='voucherError']");
	
}
