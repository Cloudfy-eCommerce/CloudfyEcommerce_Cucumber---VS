package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import com.configure.Base;
import com.helper.CommonHelper;

import com.pages.objectRepository.AddToCartPageLocators;

public class AddToCartPage {
	WebDriver driver= Base.driver;
	Actions action = new Actions(driver);
    private static Logger log = LoggerFactory.getLogger(AddToCartPage.class);
    
	public void UserSignedIn(String UName, String Pwd) {
		Base.navigate("https://ukfy02.cloudfyprod.com/v3dev4/");
		SignInPage.AcceptCookies();
		SignInPage.clickSignInLink();
		SignInPage.enterUserName(UName);
		SignInPage.enterPwd(Pwd);
		SignInPage.clickSignInButton();
		SignInPage.MyAccount();
	}
	
	public void searchProductName(String ProdName) {
		CommonHelper.sendKeystoElement(AddToCartPageLocators.Search, ProdName);
		String SearchProductXpath = CommonHelper.dynamicXpath(AddToCartPageLocators.SearchProductDyxpath, ProdName);
		//CommonHelper.clickElement(By.xpath(SearchProductXpath));
		CommonHelper.clickElement(AddToCartPageLocators.Searchicon);
		CommonHelper.clickElement(By.xpath(SearchProductXpath));
		log.info("Searched and clicked on Product successfully");
	}
	
	public void ProductNamedisplayed() {
		Boolean isdisplayed = CommonHelper.isElementDisplayed(AddToCartPageLocators.ProdNameSearched);
		Assert.assertTrue(isdisplayed);
	}
	
	public void ProductAddedInBasket(String ProdName) {
				
		//Open Basket View page
		CommonHelper.clickElement(AddToCartPageLocators.BasketIcon);
		CommonHelper.clickElement(AddToCartPageLocators.ViewBasketButton);
		log.info("Clicked on View Basket Button");
		
		//verify Product Name in Basket
		String ProductInBasketXpath = CommonHelper.dynamicXpath(AddToCartPageLocators.ProductInBasket, ProdName);
		CommonHelper.isElementDisplayed(By.xpath(ProductInBasketXpath));
		log.info("Product is displayed in Basket");
		
		//Fetch Product Price from Basket ----- Unit Price to calculate VAT amount on Product
		
		//Fetch Final Basket Amount
		/*BasketAmountAfterAddingProduct = CommonHelper.convertStringAmountToDouble(AddToCartPageLocators.BasketTotalAmount);
		log.info("Final Basket Amount " +BasketAmountAfterAddingProduct);
		
		Double BasketDiff = BasketAmountAfterAddingProduct-BasketAmountBeforeAddingProduct;
		log.info("Basket Difference "+BasketDiff);
			
		if (Double.compare(BasketDiff, ProductPrice) == 0) {
			
			log.info("Product added to Basket successfully");
        }*/
  	}
	
	public void clickProceedToCheckout() {
		CommonHelper.clickElement(AddToCartPageLocators.ProceedToCheckout);
		log.info("Clicked on Proceed To Checkout Button");
	}
	
	public void checkIAccept() {
		//CommonHelper.clickElement(AddToCartPageLocators.clickIAccept);
		driver.findElement(AddToCartPageLocators.clickIAccept).click();
		log.info("I Accept checkbox clicked");
	}
	
	public void clickPlaceOrderNow() {
		CommonHelper.clickElement(AddToCartPageLocators.PlaceOrderNow);
	}
	
	public void ThankyouForYourOrder() {
		Boolean isdisplayed = CommonHelper.isElementDisplayed(AddToCartPageLocators.ThankYouForYourOrder);
		Assert.assertTrue(isdisplayed);
	}
	
	public void HoverOverCategoryMenu(String Cat) {
		String HoverCategoryMenu = CommonHelper.dynamicXpath(AddToCartPageLocators.CategoryDyxpath, Cat);
		WebElement Category = driver.findElement(By.xpath(HoverCategoryMenu));
		action.moveToElement(Category).perform();
		log.info("Hover Over Category Menu done");
	}
	
	public void ClickSubCategoryUnderCategory(String SubCat, String Cat) {
		String ClickSubCategoryMenu = CommonHelper.dynamicXpath(AddToCartPageLocators.SubCategoryDyxpath, SubCat);
		log.info("Move to Sub Category "+ClickSubCategoryMenu);
		action.moveToElement(driver.findElement(By.xpath(ClickSubCategoryMenu))).perform();
		log.info("Click on Sub Category");
		CommonHelper.clickElement(By.xpath(ClickSubCategoryMenu));
		log.info("Clicked on Sub Category");
	}
	
	public void ClickSubSubCategoryUnderCategory(String SubSubCat, String Cat) {
		String ClickSubSubCategoryMenu = CommonHelper.dynamicXpath(AddToCartPageLocators.SubSubCategoryDyxpath, SubSubCat);
		log.info("Move to Sub Sub Category "+ClickSubSubCategoryMenu);
		action.moveToElement(driver.findElement(By.xpath(ClickSubSubCategoryMenu))).perform();
		log.info("Click on Sub Sub Category");
		CommonHelper.clickElement(By.xpath(ClickSubSubCategoryMenu));
		log.info("Clicked on Sub Sub Category");
	}
	
	public void clickProductName(String arr) {
		
		String ProdName = CommonHelper.dynamicXpath(AddToCartPageLocators.ProductDyxpath, arr);
		CommonHelper.clickElement(By.xpath(ProdName));
		log.info("Clicked on Product Name in Product List");
	}
	
	public void AddToBasket() {
		
		//Fetch initial Basket Amount
		//BasketAmountBeforeAddingProduct = CommonHelper.convertStringAmountToDouble(AddToCartPageLocators.BasketTotalAmount);
		//log.info("Default Basket Amount " +BasketAmountBeforeAddingProduct);
		
		//Fetch Product Price
		//ProductPrice = CommonHelper.convertStringAmountToDouble(AddToCartPageLocators.ProductPrice);
		//log.info("Product Price " +ProductPrice);
			
		//Add To Basket
		CommonHelper.clickElement(AddToCartPageLocators.AddToBasketButton);
		log.info("clicked on Add To Basket");
		
	}
	
	public static void RemoveFromBasket(String ProdName) {
		CommonHelper.clickElement(AddToCartPageLocators.RemoveProductFromBasket);
		log.info("Removed Product from Basket");
	}

}
