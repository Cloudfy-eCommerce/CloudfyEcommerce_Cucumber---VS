package Stepdefinition;

import com.configure.ConfigManager;
import com.pages.AddToCartPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddToCart {
	
	AddToCartPage addToCartPage = new AddToCartPage();
	
	@Given("^User is signed in on website$")
	public void user_is_Signed_in_on_website() {
		addToCartPage.UserSignedIn(ConfigManager.getAdminUname(), ConfigManager.getAdminPwd());
	}
	
	@When("^User search Product Name (.+) in auto suggest Search box on Home page$")
	public void user_search_Product_Name(String ProductName) {
		//String[] arr = CommonHelper.StringValueSeparator(ProductName);
		//for (int i=0; i < arr.length; i++)
		//{
		//addToCartPage.searchProductName(arr[i]);
		//addToCartPage.clickProductName(arr[i]);
		//addToCartPage.ProductNamedisplayed();
		//addToCartPage.AddToBasket();
		//}
		addToCartPage.searchProductName(ProductName);
	}
	
	@And("^User clicks on Add To Basket button$")
	public void user_clicks_on_add_to_basket_button() {
		addToCartPage.AddToBasket();
	}
    
	@Then("^User clicks on SubCategory (.+) under Category (.+) in Product Menu$")
	public void user_click_on_SubCategory_under_Category(String SubCategory, String Category) {
		addToCartPage.HoverOverCategoryMenu(Category);
		addToCartPage.ClickSubCategoryUnderCategory(SubCategory, Category);
	}
	
	@And("^User clicks on SubSubCategory (.+) under Category (.+) in Product Menu$")
	public void user_click_on_SubSubCategory_under_Category(String SubSubCategory, String Category) {
		addToCartPage.HoverOverCategoryMenu(Category);
		addToCartPage.ClickSubSubCategoryUnderCategory(SubSubCategory, Category);
	}
	
	@And("^User clicks on Product Name (.+) in Product List$")
	public void click_on_Product_Name_in_Product_List(String ProductName) {
		/*String[] arr = CommonHelper.ValueSeparator(ProductName);
		for (int i=0; i < arr.length; i++)
		{
		//addToCartPage.clickProductName(arr[i]);
				
		}*/
		addToCartPage.clickProductName(ProductName);
		addToCartPage.ProductNamedisplayed();
	}
	
	@Then("^Price for Product Name (.+) should be added in basket on Home Page$")
	public void price_for_Product_Name_should_be_added_in_basket(String ProductName) {
		//String[] arr = CommonHelper.StringValueSeparator(ProductName);
		//for (int i=0; i < arr.length; i++)
		//{
		//addToCartPage.ProductAddedInBasket(arr[i]);
		//}
		addToCartPage.ProductAddedInBasket(ProductName);
	}
	
	@And("^User clicks on Proceed to Checkout button in Basket$")
	public void user_clicks_on_Proceed_To_Checkout_Button() {
		addToCartPage.clickProceedToCheckout();
	}
	
	@And("^User checks I Accept checkbox in Basket$")
	public void user_checks_I_accept_checkbox() {
		addToCartPage.checkIAccept();
	}
	
	@And("^User clicks on Place Order Now button in Basket$")
	public void user_clicks_on_Place_Order_Now() {
		addToCartPage.clickPlaceOrderNow();
	}
	
	@And("^Order should be placed successfully$")
	public void Order_should_be_placed_successfully() {
		addToCartPage.ThankyouForYourOrder();
	}

}