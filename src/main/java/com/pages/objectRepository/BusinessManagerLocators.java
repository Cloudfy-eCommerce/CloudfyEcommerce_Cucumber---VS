package com.pages.objectRepository;

import org.openqa.selenium.By;

public class BusinessManagerLocators {
	
	public static By BMUsername = By.xpath("//input[@id='UserName']");
	public static By BMPassword = By.xpath("//input[@id='Password']");
	public static By BMSignIn = By.xpath("//button[text()='Sign In']");
	
	//BM Menu Generic Xpath
	public static String BMMenuDyxpath = "//span[contains(text(),'${Value}')]";
	
	//BM Sub Menu Generic Xpath
	public static String BMSubMenuDyxpath = "//a[contains(text(),'${Value}')]";
	
	//BM SiteSetting Tab Generic Xpath
	public static String BMSiteSettingTabDyxpath = "//a[contains(text(),'${Value}')]";
	
	//public static By TransactionalDocumentMenu = By.xpath("//span[text()='Transactional Documents']");
	//public static By OrdersSubMenu = By.xpath("//a[text()='Orders']");
	
	//BM TransactionalSetting Section Generic Xpath
	public static String BMTransactionalSettingSectionDyxpath = "//a[contains(text(),'${Value}')]";
	
	public static By CheckFirstOrderEntry = By.xpath("(//input[@role='checkbox'])[2]");
	
	public static By CalculateVATFromElement = By.xpath("//span[@id='select2-CalculateVatFrom-container']");
	public static By SearchDD = By.xpath("//span[@class='select2-search select2-search--dropdown']/input[@role='textbox']");
	public static String DDOptionDyxpath = "//li[text()='${Value}']";
	
	public static By VATMethodTypeElement = By.xpath("//span[@id='select2-ProductVatMethod-container']");
	
	public static By DeliveryTypeElement = By.xpath("//span[@id='select2-DeliveryType-container']");
	
	public static By DeliveryBreakdownLevelElement = By.xpath("//span[@id='select2-DeliveryBreakdownLevel-container']");
	
	public static By SubmitButton = By.xpath("//button[text()='Submit']");
}
