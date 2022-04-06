package com.pages.objectRepository;

import org.openqa.selenium.By;

public class AddToCartPageLocators {
	
	//V3dev
	/*public static By Search = By.xpath("//input[@id='SearchString']");
	public static String SearchProductDyxpath = "//a[normalize-space(text())='${Value}']";
	public static By ProdNameSearched = By.xpath("//div[@id='zoom']/following-sibling::div/child::h1");
	public static By BasketTotalAmount = By.xpath("//span[@id='lblbasketTotal']");
	public static By AddToBasketButton = By.xpath("//a[text()=' ADD TO BASKET']");
	public static By BasketIcon = By.xpath("//span[@id='lblbasketTotal']");
	public static By ViewBasketButton = By.xpath("//a[text()='View Basket']");
	public static String ProductInBasket = "//td[contains(text(),'${Value}')]";
	public static By ProductPrice = By.xpath("//span[text()=' Inc.VAT']/preceding-sibling::span");
	*/
	
	//V3dev4
	public static By Search = By.xpath("//input[@id='SearchString']");
	//public static String SearchProductDyxpath = "//span[normalize-space(text())='${Value}']";
	
	public static By Searchicon = By.xpath("//button[@id='submitSearch']/i");
	public static String SearchProductDyxpath = "//a[contains(text(),'${Value}')]";
	
	public static By ProdNameSearched = By.xpath("//div[@id='maincontents2']/div[1]/h1");
	public static By BasketTotalAmount = By.xpath("//span[@id='lblbasketTotal']");
	public static By ProductPrice = By.xpath("//span[@id='lbltotalPrice']");
	public static By AddToBasketButton = By.xpath("//button[text()='Add to Basket']");
	public static By BasketIcon = By.xpath("//span[@id='lblbasketTotal']");
	public static By ViewBasketButton = By.xpath("//a[text()='View Basket']");
	public static String ProductInBasket = "//td[contains(text(),'${Value}')]";
	
	public static By ProceedToCheckout = By.xpath("//button[text()='Proceed to checkout >']");
	public static By clickIAccept = By.xpath("//input[@id='chkiaccept']");
	public static By PlaceOrderNow = By.xpath("//*[text()='Place Order Now']");
	public static By ThankYouForYourOrder = By.xpath("//*[text()='Thank you for your order']");
	public static By RemoveProductFromBasket = By.xpath("(//a[@class='delete_icon'])[1]");
	
	//Level 1 - Mobiles and Accessories
	public static String CategoryDyxpath = "//div[@class='big_nav']/div/nav/div/div/div/ul/li/a[normalize-space(.)='${Value}'][1]";
	
	//Level 2 - Mobiles	
	public static String SubCategoryDyxpath = "(//div[starts-with(@class,'drpdwn')]/ul/li/a/h2[text()='${Value}'])[2]";
	
	//Level 3 - Power Banks
	public static String SubSubCategoryDyxpath = "(//div[starts-with(@class,'drpdwn')]/ul/li/ul/li/a[text()='${Value}'])[2]";
	
	public static String ProductDyxpathAddToBasket = "//a[contains(text(),'${Value}')]/ancestor::div[@class='inner ']/following-sibling::div/a[text()='Add to Basket']";
	public static String ProductDyxpath = "//a[contains(text(),'${Value}')]";
	
	public static By ShowDetailedDelivery = By.xpath("//span[@class='plus']");
	public static String ExtendedDeliveryChoiceDyxpath = "//span[normalize-space(text())='${Value}']/parent::td/following-sibling::td";
	//public static By ProductAdditional = By.xpath("//span[normalize-space(text())='ProductAd']/parent::td/following-sibling::td");
	//public static By ProductGroupAdditional = By.xpath("//span[normalize-space(text())='ProductGroupAd']/parent::td/following-sibling::td");
	public static String ChoiceExtendedDeliveryRadioButtonDyxpath = "//input[@id='${Value}']";
	//public static By BasketChoice = By.xpath("//input[@id='BasketChoice']");
	//public static By CustomerChoice = By.xpath("//input[@id='CustomerChoice']");
	//public static By CustomerGroupChoice = By.xpath("//input[@id='CustGroupChoice']");
}
