package com.pages.objectRepository;

import org.openqa.selenium.By;

public class VATLocators {
	
	public static By SubTotal = By.xpath("//td[text()='Sub Total']/following-sibling::td");
	public static By VatInCheckout = By.xpath("//td[text()='Vat']/following-sibling::td");
	public static By BillingCountry = By.xpath("//select[@id='Bdetail_Country']");
	public static By DiscountInCheckout = By.xpath("//td[text()='Discount']/following-sibling::td");
	
}
